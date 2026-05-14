import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            answer = Math.min(answer, zip(s, i));
        }
        return answer;
    }
    
    static int zip(String s, int len) {
        String res = "";
        
        int cnt = 1;
        for (int i = len; i <= s.length(); i += len) {
            if (i + len > s.length()) {
                if (cnt > 1) res += Integer.toString(cnt);
                res += s.substring(i-len, s.length());
                break;
            }
            
            if (s.substring(i-len, i).equals(s.substring(i, i+len))) cnt++;
            else {
                if (cnt > 1) res += Integer.toString(cnt);
                res += s.substring(i-len, i);
                cnt = 1;
            }
        }
        
        return res.length();
    }
}