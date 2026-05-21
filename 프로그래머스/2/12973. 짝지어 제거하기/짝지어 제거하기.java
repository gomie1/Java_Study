import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // 스택이 비어있거나, 짝을 찾지 못했다면 현재 문자를 스택에 삽입
            if (stack.isEmpty() || (!stack.isEmpty() && stack.peek() != s.charAt(i))) stack.push(s.charAt(i));
            else stack.pop(); // 짝을 찾으면 스택에서 제거
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}