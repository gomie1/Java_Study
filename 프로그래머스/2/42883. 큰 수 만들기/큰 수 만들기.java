import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int cnt = k;
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && cnt-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        
        String answer = "";
        for (int i = 0; i < number.length() - k; i++) {
            answer += stack.get(i);
        }
        return answer;
    }
}