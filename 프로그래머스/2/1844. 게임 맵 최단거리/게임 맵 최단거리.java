import java.util.*;

class Solution {
    static int r, c;
    
    public int solution(int[][] maps) {
        r = maps.length;
        c = maps[0].length;
        
        bfs(maps);
        return maps[r-1][c-1] == 1 ? -1 : maps[r-1][c-1];
    }
    
    static void bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        
        boolean[][] visited = new boolean[r][c];
        visited[0][0] = true;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx < 0 || nx >= r || ny < 0 || ny >= c || visited[nx][ny] || maps[nx][ny] == 0) continue;
                
                q.add(new int[] {nx, ny});
                visited[nx][ny] = true;
                maps[nx][ny] = maps[cur[0]][cur[1]] + 1;
            }
        }
    }
}