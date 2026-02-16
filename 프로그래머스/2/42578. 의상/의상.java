import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 1. 옷의 종류 별로 가짓 수 카운팅
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] s : clothes) {
            // 해당 옷 종류를 안입는 경우도 존재하기 때문에 기본 값을 1로 초기화
            map.put(s[1], map.getOrDefault(s[1], 1) + 1);
        }
        
        // 2. 경우의 수 계산
        int answer = 1;
        for (String key : map.keySet()) {
            answer *= map.get(key);
        }
        
        return answer - 1; // 아무것도 입지 않는 공집합의 경우를 하나 빼줌
    }
}