import java.util.*;

class Solution {
    static int[] answer;
    public int[] solution(int[][] users, int[] emoticons) {
        // 1. 각 이모티콘별 할인율 정하기 (중복조합)
        int[] discount = new int[emoticons.length];
        answer = new int[2];
        combination(discount, 0, users, emoticons);
        
        return answer;
    }
    
    static void combination(int[] discount, int idx, int[][] users, int[] emoticons) {
        if (idx == discount.length) {
            // 2. 각각의 할인율대로 할인한 가격 계산하기
            calculate(discount, users, emoticons);
            return;
        }
        
        for (int i = 10; i <= 40; i += 10) {
            discount[idx] = i;
            combination(discount, idx+1, users, emoticons);
        }
    }
    
    static void calculate(int[] discount, int[][] users, int[] emoticons) {
        int[] price = new int[discount.length];
        for (int i = 0; i < discount.length; i++) {
            price[i] = emoticons[i] - (emoticons[i] * discount[i] / 100);
        }
        
        // 3. 행사 결과 계산하기
        int emoticonPlus = 0;
        int sales = 0;
        for (int i = 0; i < users.length; i++) {
            int sum = 0;
            for (int j = 0; j < discount.length; j++) {
                if (users[i][0] <= discount[j]) sum += price[j];
            }
            
            if (users[i][1] <= sum) emoticonPlus++;
            else sales += sum;
        }
        
        // 4. 최대 달성 결과 갱신하기
        if (answer[0] < emoticonPlus) {
            answer[0] = emoticonPlus;
            answer[1] = sales;
        } else if (answer[0] == emoticonPlus && answer[1] < sales) {
            answer[1] = sales;
        }
    }
}