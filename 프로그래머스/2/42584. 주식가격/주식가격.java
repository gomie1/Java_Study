import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        for (int sec = 0; sec < n; sec++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[sec]) {
                int idx = stack.pop();
                answer[idx] = sec - idx;
            }
            stack.push(sec);
        }
        
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = (n-1) - idx;
        }
    
        return answer;
    }
}