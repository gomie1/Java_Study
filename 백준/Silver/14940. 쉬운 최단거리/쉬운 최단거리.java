import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[] start = new int[2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) result[i][j] = 0;
                else result[i][j] = -1;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.offer(new int[] {start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            result[cur[0]][cur[1]] = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m ||
                        visited[nx][ny] || map[nx][ny] == 0) continue;

                q.offer(new int[] {nx, ny, cur[2]+1});
                visited[nx][ny] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}