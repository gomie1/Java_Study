import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            int n = number.charAt(i) - '0';
            while (!stack.isEmpty() && k > 0 && stack.peek() < n) {
                stack.pop();
                k--;
            }
            stack.push(n);
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}