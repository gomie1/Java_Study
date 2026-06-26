import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        return bfs(maps, maps.length, maps[0].length);
    }
    
    static int bfs(int[][] maps, int n, int m) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0, 1}); // 시작 위치는 (0, 0), 첫 위치부터 카운팅
        
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == n-1 && cur[1] == m-1) return cur[2];
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || maps[nx][ny] == 0 || visited[nx][ny]) continue;
                
                q.add(new int[] {nx, ny, cur[2]+1});
                visited[nx][ny] = true;
            }
        }
        
        return -1;
    }
}