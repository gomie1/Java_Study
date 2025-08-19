import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] tomato = new int[N][M][H];
        int zero = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < M; j++) {
                    tomato[i][j][h] = Integer.parseInt(st.nextToken());

                    if (tomato[i][j][h] == 0) zero++;
                    else if (tomato[i][j][h] == 1) q.offer(new int[] {i, j, h});
                }
            }
        }

        if (zero == 0) {
            System.out.println(0);
            return;
        }

        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dh = {0, 0, 0, 0, -1, 1};

        int ans = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 6; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int nh = cur[2] + dh[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M ||
                        nh < 0 || nh >= H || tomato[nx][ny][nh] != 0) continue;

                q.offer(new int[] {nx, ny, nh});
                tomato[nx][ny][nh] = tomato[cur[0]][cur[1]][cur[2]] + 1;
                ans = Math.max(ans, tomato[nx][ny][nh]);
                zero--;
            }
        }

        if (zero == 0) System.out.println(ans-1);
        else System.out.println(-1);
    }
}