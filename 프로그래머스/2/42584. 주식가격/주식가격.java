import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        Stack<Integer> stack = new Stack<>(); // sec
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx; // 떨어진 시점 - 들어온 시점 = 떨어지지 않은 채로 버틴 시간
                // ex. 2초에서 3이었는데, 3초에서 2로 떨어졌다면 -> 2초 기준에서 1초동안 유지한 것!!
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = n - 1 - idx;
        }
        
        return answer;
    }
}