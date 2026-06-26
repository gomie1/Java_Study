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
    
    static void bfs(int[][] computers, int n, int node) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(node);
        visited[node] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int nxt = 0; nxt < n; nxt++) {
                if (cur == nxt || visited[nxt]) continue;
                if (computers[cur][nxt] == 1) {
                    q.add(nxt);
                    visited[nxt] = true;
                }
            }
        }
    }
}