import java.util.*;

class Solution {
    static boolean visited[];
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void bfs(int start, int n, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int i = 0; i < n; i++) {
                if (i == cur) continue;
                if (!visited[i] && computers[cur][i] == 1) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}