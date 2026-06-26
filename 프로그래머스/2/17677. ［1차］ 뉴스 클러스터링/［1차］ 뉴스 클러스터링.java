import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 소문자로 통일
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // 다중 집합 만들기
        Map<String, Integer> A = new HashMap<>(); // <원소, 원소의 개수>
        for (int i = 0; i < str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            if (c1 < 'a' || c1 > 'z') continue;
            
            char c2 = str1.charAt(i+1);
            if (c2 < 'a' || c2 > 'z') continue;
            
            String key = str1.substring(i, i+2);
            A.put(key, A.getOrDefault(key, 0) + 1);
        }
        
        Map<String, Integer> B = new HashMap<>(); // <원소, 원소의 개수>
        for (int i = 0; i < str2.length() - 1; i++) {
            char c1 = str2.charAt(i);
            if (c1 < 'a' || c1 > 'z') continue;
            
            char c2 = str2.charAt(i+1);
            if (c2 < 'a' || c2 > 'z') continue;
            
            String key = str2.substring(i, i+2);
            B.put(key, B.getOrDefault(key, 0) + 1);
        }
        
        int intersection = 0; // 교집합 크기
        int union = 0; // 합집합 크기
        
        // 두 Map의 Key를 중복 없이 모으기
        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(A.keySet());
        allKeys.addAll(B.keySet());
        
        for (String key : allKeys) {
            int countA = A.getOrDefault(key, 0);
            int countB = B.getOrDefault(key, 0);

            // 다중집합 규칙: 교집합은 두 개수 중 최소값, 합집합은 최대값!
            intersection += Math.min(countA, countB);
            union += Math.max(countA, countB);
        }
        
        // 둘 다 공집합(합집합이 0)일 때 예외 처리
        if (union == 0) return 65536;
        
        double answer = (double) intersection / union;
        return (int) (answer * 65536);
    }
}