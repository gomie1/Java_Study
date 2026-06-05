import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 1. 마라톤을 완주한 선수를 모두 Map에 담기
        // (* 동명이인이 있기 때문에, 이름 별 숫자 카운팅을 위해 Set이 아닌 Map 선택)
        Map<String, Integer> map = new HashMap<>();
        for (String name : completion) map.put(name, map.getOrDefault(name, 0) + 1);
        
        // 2. 참가자 명단을 확인하며 map에 없는 사람이면 정답 처리
        for (String name : participant) {
            if (!map.containsKey(name) || map.get(name) == 0) return name;
            map.put(name, map.get(name) - 1);
        }
        
        return "";
    }
}