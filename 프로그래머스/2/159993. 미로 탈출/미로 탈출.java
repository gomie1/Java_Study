import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        
        int[] start = new int[2];
        int[] end = new int[2];
        int[] lever = new int[2];
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (maps[x].charAt(y) == 'S') {
                    start[0] = x;
                    start[1] = y;
                } else if (maps[x].charAt(y) == 'L') {
                    lever[0] = x;
                    lever[1] = y;
                } else if (maps[x].charAt(y) == 'E') {
                    end[0] = x;
                    end[1] = y;
                }
            }
        }
        
        int path1 = bfs(start, lever, n, m, maps);
        if (path1 == -1) return -1; // start to lever에 실패하면 -1 반환 후 종료
        
        int path2 = bfs(lever, end, n, m, maps);
        if (path2 == -1) return -1; // lever to end에 실패하면 -1 반환 후 종료
        
        return path1 + path2; // 두 경로 모두 이동 가능하다면 최단 거리를 합산해서 출력
    }
    
    static int bfs(int[] start, int[] end, int n, int m, String[] maps) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        // 시작 위치를 큐에 삽입 및 방문 처리
        q.add(new int[] {start[0], start[1], 0}); // [x, y, dist]
        visited[start[0]][start[1]] = true;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                // 다음 위치가 미로를 벗어나거나, 이미 방문했거나, 벽이라면 패스!
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || maps[nx].charAt(ny) == 'X') continue;
                
                // 다음 위치가 목적지라면 종료!
                if (nx == end[0] && ny == end[1]) return cur[2] + 1;
                
                // 위 조건을 통과한다면, 다음 위치로 이동 및 거리 갱신
                q.add(new int[] {nx, ny, cur[2]+1});
                visited[nx][ny] = true;
            }
        }
        
        return -1; // 목적지에 도착하지 못했다면 -1 반환
    }
}