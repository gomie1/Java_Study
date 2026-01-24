import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] grid;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        grid = new char[N][N];
        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        // 1. 적록색약이 아닌 경우
        visited = new boolean[N][N];
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, grid[i][j]);
                    cnt++;
                }
            }
        }
        sb.append(cnt).append(" ");

        // 2. 적록색약인 경우
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 'R') grid[i][j] = 'G';
            }
        }

        visited = new boolean[N][N];
        cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, grid[i][j]);
                    cnt++;
                }
            }
        }
        sb.append(cnt);
        System.out.println(sb);
    }

    static void bfs(int sx, int sy, char color) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {sx, sy});
        visited[sx][sy] = true;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || grid[nx][ny] != color) continue;

                visited[nx][ny] = true;
                dq.offer(new int[] {nx, ny});
            }
        }
    }
}