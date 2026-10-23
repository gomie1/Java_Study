import java.util.*;

class Solution {
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    static void dfs(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length) {
            if (sum == target) answer++;
            return;
        }
        
        // 현재 숫자를 더하기
        dfs(numbers, target, idx+1, sum+numbers[idx]);
        
        // 현재 숫자를 빼기
        dfs(numbers, target, idx+1, sum-numbers[idx]);
    }
}