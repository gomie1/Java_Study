import java.util.*;

class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(computers, n, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void bfs(int[][] computers, int n, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int nxt = 0; nxt < n; nxt++) {
                if (nxt == cur || computers[cur][nxt] == 0 || visited[nxt]) continue;
                
                q.add(nxt);
                visited[nxt] = true;
            }
        }
    }
}