import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for (int n : arr) {
            if (stack.isEmpty() || stack.peek() != n) stack.add(n);
        }
        
        Stack<Integer> stack2 = new Stack<>();
        while (!stack.isEmpty()) stack2.add(stack.pop());
        
        int[] answer = new int[stack2.size()];
        int idx = 0;
        while (!stack2.isEmpty()) answer[idx++] = stack2.pop();
        
        return answer;
    }
}