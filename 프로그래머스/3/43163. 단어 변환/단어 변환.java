import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // words에 target 유무 확인
        boolean flag = false;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) flag = true;
        }
        
        // 주어진 단어의 집합에 target이 없으면 변환할 수 없음
        if (!flag) return 0;
        
        // 가장 짧은(최소) 변환 과정을 찾아야 하므로 BFS 사용
        return bfs(begin, target, words);
    }
    
    static int bfs(String begin, String target, String[] words) {
        Queue<String[]> q = new LinkedList<>(); // {단어의 인덱스, 변환 횟수}
        q.add(new String[] {begin, "0"});
        boolean[] visited = new boolean[words.length];
        
        int res = 0;
        while (!q.isEmpty()) {
            String[] cur = q.poll();
            if (cur[0].equals(target)) { // 현재 단어가 타겟 단어라면 종료
                res = Integer.parseInt(cur[1]);
                break; 
            }
            
            for (int nxt = 0; nxt < words.length; nxt++) {
                if (visited[nxt] || !isChanged(cur[0], words[nxt])) continue;
                
                int cnt = Integer.parseInt(cur[1]) + 1;
                q.add(new String[] {words[nxt], Integer.toString(cnt)});
                visited[nxt] = true;
            }
        }
        
        return res;
    }
    
    static boolean isChanged(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        
        return diff == 1;
    }
}