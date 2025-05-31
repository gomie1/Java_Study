import java.io.*;
import java.util.*;

public class Main {
    static int N, M, mtrx[][], cnt, ans;
    static Queue<int[]> queue;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        mtrx = new int[N][M];
        queue = new LinkedList<>();
        cnt = 0; // 익지 않은 토마토의 개수
        ans = 0; // 날짜
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                mtrx[i][j] = Integer.parseInt(st.nextToken());
                if (mtrx[i][j] == 1) queue.offer(new int[] {i, j, 0});
                else if (mtrx[i][j] == 0) cnt++;
            }
        }

        if (cnt == 0) {
            System.out.println(ans);
            return;
        }

        bfs();
        if (cnt == 0) System.out.println(ans);
        else System.out.println(-1);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (ans < cur[2]) ans = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || mtrx[nx][ny] != 0) continue;

                queue.offer(new int[] {nx, ny, cur[2] + 1});
                mtrx[nx][ny] = 1;
                cnt--;
            }
        }
    }
}