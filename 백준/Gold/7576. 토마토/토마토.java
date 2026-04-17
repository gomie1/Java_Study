import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] tomato = new int[N][M];
        Queue<int[]> q = new LinkedList<>(); // {x, y, day}
        int cnt = 0; // 덜익은 토마토의 개수
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 0) cnt++;
                else if (tomato[i][j] == 1) q.add(new int[] {i, j, 0});
            }
        }

        // 이미 모든 토마토가 다 익었다면 시간이 걸리지 않음
        if (cnt == 0) {
            System.out.println(0);
            return;
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || tomato[nx][ny] != 0) continue;

                q.add(new int[] {nx, ny, cur[2]+1});
                tomato[nx][ny] = 1;
                cnt--;

                if (cnt == 0) {
                    System.out.println(cur[2]+1);
                    return;
                }
            }
        }

        System.out.println(-1);
    }
}