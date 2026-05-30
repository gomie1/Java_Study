import java.util.*;

class Solution {
    static int n, m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        int answer = play(maps);
        return answer;
    }
    
    static int play(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        // 캐릭터의 초기 위치 설정
        q.add(new int[] {0, 0, 1}); // [x, y, dist]
        visited[0][0] = true;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                // 다음 위치가 맵을 벗어나거나, 이미 방문한 위치이거나, 벽이라면 패스!
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || maps[nx][ny] == 0) continue;
                
                // 다음 위치가 상대 팀 진영이라면 종료!
                if (nx == n-1 && ny == m-1) return cur[2]+1;
                
                // 위 조건을 통과한다면, 다음 위치로 이동 및 최단 거리 갱신
                q.add(new int[] {nx, ny, cur[2]+1});
                visited[nx][ny] = true;
            }
        }
        
        return -1;
    }
}