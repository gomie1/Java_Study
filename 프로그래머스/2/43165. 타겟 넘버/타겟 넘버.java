import java.util.*;

class Solution {
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0, 0, target, numbers);
        return answer;
    }
    
    static void dfs(int cur, int idx, int target, int[] numbers) {
        // 모든 숫자에 대해 연산을 했다면 종료
        if (idx == numbers.length) {
            if (cur == target) answer++;
            return;
        }
        
        // 현재 숫자 더하기
        dfs(cur+numbers[idx], idx+1, target, numbers);
        
        // 현재 숫자 빼기
        dfs(cur-numbers[idx], idx+1, target, numbers);
    }
}