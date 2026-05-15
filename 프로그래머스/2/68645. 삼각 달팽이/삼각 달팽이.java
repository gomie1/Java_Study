import java.util.*;

class Solution {
    static int max;
    
    public int[] solution(int n) {
        max = 0;
        for (int i = 1; i <= n; i++) max += i;
        
        int[][] arr = snail(n);
        
        int[] answer = new int[max];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = arr[i][j];
            }
        }
        
        return answer;
    }
    
    static int[][] snail(int n) {
        int[][] arr = new int[n][n];
        int num = 1;
        
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        
        // 삼각형을 제외한 부분 모두 미리 방문처리
        for (int r = 0; r < n-1; r++) {
            for (int c = r+1; c < n; c++) {
                visited[r][c] = true;
            }
        }
        
        int d = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            arr[cur[0]][cur[1]] = num++;
            if (num > max) break;
            
            int nx = cur[0] + dx[d];
            int ny = cur[1] + dy[d];
            
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {
                d = (d + 1) % 3;
                nx = cur[0] + dx[d];
                ny = cur[1] + dy[d];
            }
            
            q.add(new int[] {nx, ny});
            visited[nx][ny] = true;
        }
        
        return arr;
    }
}