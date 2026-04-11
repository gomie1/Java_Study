import java.io.*;
import java.util.*;

public class Main {
    static int N, M, arr[][];

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()); // 0: 청소 X 빈칸, 1: 벽
            }
        }

        System.out.println(cleaning(sx, sy, d));
    }

    static int cleaning(int x, int y, int d) {
        // 0: 북쪽, 1: 동쪽, 2: 남쪽, 3: 서쪽
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int cnt = 0;
        while (true) {
            // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (arr[x][y] == 0) {
                arr[x][y] = 2; // 2: 청소 표시
                cnt++;
            }
            
            // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸의 존재 여부 확인
            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] != 0) continue;

                flag = true;
                break;
            }

            // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if (!flag) {
                int nx = x + dx[(d+2) % 4];
                int ny = y + dy[(d+2) % 4];

                // 2-1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] != 1) {
                    x = nx;
                    y = ny;
                }

                // 2-2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                else break;
            }

            // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
            if (flag) {
                for (int i = 0; i < 4; i++) {
                    // 3-1. 반시계 방향으로 90도 회전한다.
                    d = (d+3) % 4;

                    // 3-2. 바라보는 뱡향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 0) {
                        x = nx;
                        y = ny;
                        break;
                    }
                }
            }
        }

        return cnt;
    }
}