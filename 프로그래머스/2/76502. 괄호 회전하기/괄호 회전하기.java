import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1) + s.charAt(0);
            if (isRight(s)) answer++;
        }     
        return answer;
    }
    
    static boolean isRight(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[' || c == '(' || c == '{') stack.add(c);
            else {
                if (!stack.isEmpty() && ((stack.peek() == '[' && c == ']') || (stack.peek() == '(' && c == ')') || (stack.peek() == '{' && c == '}'))) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}