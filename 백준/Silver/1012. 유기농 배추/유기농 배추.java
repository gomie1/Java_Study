import java.io.*;
import java.util.*;

public class Main {
    static int N, M, map[][];
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new int[M][N];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            visited = new boolean[M][N];
            int ans = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        ans++;
                    }
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }

    static void bfs(int sx, int sy) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sx, sy});
        visited[sx][sy] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] == 0) continue;

                q.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
}