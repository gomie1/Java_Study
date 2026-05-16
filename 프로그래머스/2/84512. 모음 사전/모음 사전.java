import java.util.*;

class Solution {
    static char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    static int answer;
    static boolean isFound;
    
    public int solution(String word) {
        answer = 0;
        isFound = false;
        dfs("", 0, word);
        return answer;
    }
    
    static void dfs(String cur, int cnt, String word) {
        if (isFound || cnt > 5) return;
        
        if (cur.equals(word)) {
            isFound = true;
            return;
        }
        
        answer++;
        for (int i = 0; i < 5; i++) {
            if (isFound) return;
            dfs(cur+alphabet[i], cnt+1, word);
        }
    }
}