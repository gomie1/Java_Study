import java.util.*;

class Solution {
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        subset(0, 0, numbers.length, numbers, target);
        return answer;
    }
    
    static void subset(int sum, int idx, int n, int[] numbers, int target) {
        if (idx == n) {
            if (sum == target) answer++;
            return;
        }
        
        // 현재 숫자를 빼는 경우
        subset(sum-numbers[idx], idx+1, n, numbers, target);
        
        // 현재 숫자를 더하는 경우
        subset(sum+numbers[idx], idx+1, n, numbers, target);
    }
}