import java.io.*;
import java.util.*;

public class Main {
    static int N, M, map[][];

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

        System.out.println(bfs(0, 0));
    }

    static int bfs(int sx, int sy) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {sx, sy ,1});

        int[][] ans = new int[N][M];
        ans[sx][sy] = 1;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || ans[nx][ny] != 0 || map[nx][ny] == 0) continue;

                ans[nx][ny] = cur[2] + 1;
                dq.offer(new int[] {nx, ny, ans[nx][ny]});
            }
        }

        return ans[N-1][M-1];
    }
}