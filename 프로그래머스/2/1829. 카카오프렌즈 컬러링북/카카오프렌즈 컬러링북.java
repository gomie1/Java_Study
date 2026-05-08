import java.util.*;

class Solution {
    static boolean visited[][];
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, m, n, picture[i][j], picture));
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    static int bfs(int sx, int sy, int m, int n, int color, int[][] picture) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sx, sy});
        visited[sx][sy] = true;
        
        int cnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            cnt++;
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny] || picture[nx][ny] == 0 || picture[nx][ny] != color) continue;
                
                q.add(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }
        
        return cnt;
    }
}