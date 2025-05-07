import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length();
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < len; i++) {
            char c = number.charAt(i);
            
            while(!stack.isEmpty() && k > 0 && stack.peek() < c) {
                stack.pop();
                k--;
            }
            
            stack.push(c);
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        for(int i = 0; i < stack.size(); i++) {
            answer.append(stack.get(i));
        }
        return answer.toString();
    }
}