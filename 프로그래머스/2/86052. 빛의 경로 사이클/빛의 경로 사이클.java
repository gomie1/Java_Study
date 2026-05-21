import java.util.*;

class Solution {
    static int n, m;
    static boolean[][][] visited;
    
    // 상, 우, 하, 좌 (시계방향)
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public int[] solution(String[] grid) {
        n = grid.length;
        m = grid[0].length();
        visited = new boolean[n][m][4]; // 행, 열, 들어온 방향
        List<Integer> res = new ArrayList<>();
        
        // 모든 칸, 모든 방향을 시작점으로 시도
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 0; d < 4; d++) {
                    if (!visited[i][j][d]) res.add(getCycleLen(i, j, d, grid));
                }
            }
        }
        
        // 사이클의 모든 길이를 오름차순 정렬
        Collections.sort(res);
        
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }
    
    static int getCycleLen(int x, int y, int d, String[] grid) {
        int length = 0;
        
        while (!visited[x][y][d]) {
            // 현재 상태 방문 처리 및 사이클 거리 증가
            visited[x][y][d] = true;
            length++;
            
            // 알파벳에 맞게 방향 전환하기
            if (grid[x].charAt(y) == 'L') d = (d + 3) % 4; // 좌회전
            else if (grid[x].charAt(y) == 'R') d = (d + 1) % 4; // 우회전
            
            // 방향대로 이동 (격자 벗어남 방지를 위한 식)
            x = (x + dx[d] + n) % n;
            y = (y + dy[d] + m) % m;
        }
        
        return length;
    }
}