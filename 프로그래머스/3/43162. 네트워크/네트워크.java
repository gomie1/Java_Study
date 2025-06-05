import java.util.*;

class Solution {
    static boolean[][] visited;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (!visited[i][j] && computers[i][j] == 1) {
                    bfs(i, j, n, computers);
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    static void bfs (int start_x, int start_y, int n, int[][] computers) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {start_x, start_y});
        visited[start_x][start_y] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || computers[nx][ny] == 0) continue;
                
                visited[nx][ny] = true;
                q.offer(new int[] {nx, ny});
            }
        }
    }
}