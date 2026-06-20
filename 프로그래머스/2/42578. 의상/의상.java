import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] c : clothes) {
            // default 값은 안입는 경우를 포함해서 1로 지정
            map.put(c[1], map.getOrDefault(c[1], 1) + 1); 
        }
        
        int answer = 1;
        for (String key : map.keySet()) {
            answer *= map.get(key);
        }
        
        return answer - 1; // 아무것도 안입는 경우 제외
    }
}