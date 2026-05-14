import java.util.*;

class Solution {
    public String solution(String p) {
        // 이미 올바른 괄호 문자열인 경우 예외 처리
        if (isCorrect(p)) return p;
        return changeStr(p);
    }
    
    static String changeStr(String w) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열 반환
        if (w.isEmpty()) return w;
        
        // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리
        String u = "";
        String v = "";
        int open = 0;
        int close = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') open++;
            else close++;
            
            if (close == open) {
                u = w.substring(0, i+1);
                v = w.substring(i+1, w.length());
                break;
            }
        }
        
        if (u.isEmpty()) u = w;
        
        // 3. u가 "올바론 괄호 문자열"인 경우 
        if (isCorrect(u)) {
            StringBuilder sb = new StringBuilder();
            return sb.append(u).append(changeStr(v)).toString(); // v에 대해 1단계부터 다시 수행
        } else { // 4. u가 "올바른 괄호 문자열"이 아닌 경우 새로운 문자열 만들기
            StringBuilder tmp = new StringBuilder();
            tmp.append("(").append(changeStr(v)).append(")");

            for (int i = 1; i < u.length() - 1; i++) {
                tmp.append(u.charAt(i) == '(' ? ')' : '(');
            }
            
            return tmp.toString();
        }
    }
    
    // "올바른 괄호 문자열" 판별
    static boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push('(');
            else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}