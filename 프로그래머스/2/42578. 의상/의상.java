import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 1. 종류별 옷 개수 카운팅
        Map<String, Integer> map = new HashMap<>();
        for (String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }
        
        // 옷 종류가 하나라면 한개씩 밖에 입지 못함
        if (map.size() == 1) return clothes.length;
        
        // 2. 경우의 수 구하기
        int answer = 1;
        for (String c : map.keySet()) {
            answer *= map.get(c) + 1;
        }
        
        return answer-1;
    }
}