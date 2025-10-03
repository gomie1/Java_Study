import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> index = new HashMap<>();
        for (int i = 0; i < friends.length; i++) index.put(friends[i], i);
        
        int[][] giftTable = new int[friends.length][friends.length];
        for (String gift : gifts) {
            String[] info = gift.split(" ");
            giftTable[index.get(info[0])][index.get(info[1])]++;
        }
        
        // * 선물 지수: (이번 달까지) 자신이 친구들에게 준 선물의 수 - 받은 선물의 수
        // ex. 준 선물 = 3, 받은 선물 = 10 -> 선물 지수 = 3 - 10 = -7
        int[] score = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            int give = 0;
            int get = 0;
            
            for (int j = 0; j < friends.length; j++) {
                give += giftTable[i][j];
                get += giftTable[j][i];
            }
            
            score[i] = give - get;
        }
        
        int[] cnt = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;
                
                // 1. 선물을 주고받은 기록이 있는 경우
                if (giftTable[i][j] != 0 || giftTable[j][i] != 0) {
                    // 1-1. 주고받은 수가 다른 경우
                    if (giftTable[i][j] > giftTable[j][i]) cnt[i]++;
                }
                
                // 2. 선물을 주고받은 기록이 없거나 주고받은 수가 같은 경우
                if (giftTable[i][j] == giftTable[j][i]) {
                    // 2-1. 선물 지수가 다른 경우
                    if (score[i] != score[j] && score[i] > score[j]) {
                        cnt[i]++;
                    }
                    // 2-2. 선물 지수가 같은 경우 -> pass
                }
            }
        }

        int answer = 0;
        for (int val : cnt) if (answer < val) answer = val;
        return answer;
    }
}