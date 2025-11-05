import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 1. map에 완주자들의 이름을 넣음 (동명이인 체크)
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : completion) map.put(s, map.getOrDefault(s, 0)+1);
        
        // 2. 참여자 중 map에 없는 참여자의 이름을 반환
        String ans = "";
        for (String s : participant) {
            if (!map.containsKey(s) || map.get(s) == 0) {
                ans = s;
                break;
            }
            map.put(s, map.get(s)-1);
        }
        
        return ans;
    }
}