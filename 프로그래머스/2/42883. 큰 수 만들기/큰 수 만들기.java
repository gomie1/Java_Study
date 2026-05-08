import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        for (int i = 0; i < number.length(); i++) {
            while (!stack.isEmpty() && cnt < k && stack.peek() < number.charAt(i)) {
                stack.pop();
                cnt++;
            }
            stack.push(number.charAt(i));
        }
        
        // 숫자를 다 돌았는데, 아직 제거해야 할 횟수가 남은 경우
        if (cnt < k) {
            while (cnt < k) {
                stack.pop();
                cnt++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        
        return sb.reverse().toString();
    }
}