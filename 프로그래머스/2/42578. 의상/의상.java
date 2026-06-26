import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String[] c : clothes) {
            // 해당 종류의 의상을 입지 않는 경우도 있기에, 초기값을 1로 설정
            cnt.put(c[1], cnt.getOrDefault(c[1], 1) + 1);
        }
        
        int answer = 1;
        for (String key : cnt.keySet()) {
            answer *= cnt.get(key);
        }
        return answer - 1; // 아무것도 입지 않는 경우는 제외
    }
}