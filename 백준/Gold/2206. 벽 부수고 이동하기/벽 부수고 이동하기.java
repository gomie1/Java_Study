import java.io.*;
import java.util.*;

public class Main {
    static int N, M, map[][], ans;
    static boolean visited[][][];

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        visited = new boolean[N][M][2];
        ans = -1;
        bfs(0, 0);
        System.out.println(ans);
    }

    static void bfs(int sx, int sy) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {sx, sy, 1, 0}); // {x, y, dist, isBreak}

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            if (cur[0] == N-1 && cur[1] == M-1) {
                ans = cur[2];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny][cur[3]]) continue;

                if (map[nx][ny] == 0) {
                    visited[nx][ny][cur[3]] = true;
                    dq.offer(new int[] {nx, ny, cur[2]+1, cur[3]});
                    continue;
                }

                if (map[nx][ny] == 1 && cur[3] == 0) {
                    visited[nx][ny][1] = true;
                    dq.offer(new int[] {nx, ny, cur[2]+1, 1});
                }
            }
        }
    }
}