import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 1. map을 사용해 의상 종류별로 의상의 개수 카운팅
        Map<String, Integer> map = new HashMap<>();
        for (String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 1) + 1);
        }
        
        // 2. 모든 경우의 수 구하기
        int answer = 1;
        for (String key : map.keySet()) {
            answer *= map.get(key);
        }
        
        return answer - 1; // 아무것도 입지 않는 경우는 제외한 결과 반환
    }
}