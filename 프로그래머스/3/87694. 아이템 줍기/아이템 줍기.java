import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[101][101]; // 좌표 2배 확장
        
        // 1. 사각형 그리기
        for (int[] rect : rectangle) {
            for (int x = rect[0] * 2; x <= rect[2] * 2; x++) {
                for (int y = rect[1] * 2; y <= rect[3] * 2; y++) {
                    map[x][y] = 1;
                }
            }
        }
        
        // 2. 사각형 내부 파내기
        for (int[] rect : rectangle) {
            for (int x = rect[0] * 2 + 1; x < rect[2] * 2; x++) {
                for (int y = rect[1] * 2 + 1; y < rect[3] * 2; y++) {
                    map[x][y] = 0;
                }
            }
        }
        
        return bfs(map, characterX*2, characterY*2, itemX*2, itemY*2);
    }
    
    static int bfs(int[][] map, int sx, int sy, int ex, int ey) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[101][101];
        
        q.add(new int[] {sx, sy, 0});
        visited[sx][sy] = true;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx < 0 || nx > 100 || ny < 0 || ny > 100 || visited[nx][ny] || map[nx][ny] == 0) continue;
                
                if (nx == ex && ny == ey) return (cur[2] + 1) / 2;
                
                q.add(new int[] {nx, ny, cur[2]+1});
                visited[nx][ny] = true;
            }
        }
        
        return 0;
    }
}