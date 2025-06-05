import java.util.*;

class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, n, computers);
                answer++;
            }
        }
        return answer;
    }
    
    void bfs(int node, int len, int[][] arr) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for(int nxt = 0; nxt < len; nxt++) {
                if (!visited[nxt] && arr[cur][nxt] == 1) {
                    q.offer(nxt);
                    visited[nxt] = true;
                }
            }
        }
    }
}