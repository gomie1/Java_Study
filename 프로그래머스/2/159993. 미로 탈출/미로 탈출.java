import java.util.*;

class Solution {
    static int n, m;
    static char map[][];
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        map = new char[n][m];
        int[] start = new int[2];
        int[] end = new int[2];
        int[] lever = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = maps[i].charAt(j);
                
                if (map[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (map[i][j] == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                } else if (map[i][j] == 'E') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        
        int t1 = bfs(start, lever);
        if (t1 == -1) return -1;
        
        int t2 = bfs(lever, end);
        return t2 == -1 ? -1 : t1+t2;
    }
    
    static int bfs(int[] start, int[] end) {
        Queue<int[]> q = new LinkedList<>(); // {x, y, time}
        q.add(new int[] {start[0], start[1], 0});
        boolean[][] visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] == 'X') continue;
                
                if (nx == end[0] && ny == end[1]) return cur[2] + 1;
                q.add(new int[] {nx, ny, cur[2]+1});
                visited[nx][ny] = true;
            }
        }
        
        return -1;
    }
}