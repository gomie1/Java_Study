import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        // 금액이 작은 부서부터 지원해줘야 최대한 많이 지원해 줄 수 있으므로 정렬하기!
        Arrays.sort(d);
        
        int sum = 0;
        int answer = 0;
        for (int n : d) {
            sum += n;
            if (sum > budget) break;
            
            answer++;
        }
        
        return answer;
    }
}