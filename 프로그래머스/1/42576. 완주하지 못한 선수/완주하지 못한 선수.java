import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 1. 동명이인까지 체크하기 위해 완주자 map 생성
        HashMap<String, Integer> map = new HashMap<>(); // key: 이름, value: 인원수
        for (String name : completion) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        // 2. 참가자 배열을 순회하며 map에 없는 이름 탐색
        String answer = "";
        for (String name : participant) {
            if (!map.containsKey(name) || map.get(name) == 0) {
                answer = name;
                break;
            }
            
            map.put(name, map.get(name) - 1);
        }
        
        return answer;
    }
}