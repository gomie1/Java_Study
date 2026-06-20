import java.util.*;

class Solution {
    boolean solution(String s) {
        // 1. 괄호 짝 검사
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.add(c);
            else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        
        // 2. 검사가 끝난 후에 스택이 비어있지 않으면 올바르지 않음
        if (!stack.isEmpty()) return false;
        return true;
    }
}