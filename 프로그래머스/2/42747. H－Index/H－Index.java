import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length; // 논문의 수
        Arrays.sort(citations); // [0, 1, 3, 5, 6]
        
        for (int i = 0; i < n; i++) {
            int h = n - i; // 현재 논문을 포함하여, 이보다 인용 횟수가 같거나 많은 논문의 개수
            if (h <= citations[i]) return h; // 현재 논문의 인용 횟수가 h번 이상인지 확인
        }
        
        return 0;
    }
}