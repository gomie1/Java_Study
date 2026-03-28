import java.io.*;
import java.util.*;

public class Main {
    static int W, H, map[][];
    static boolean[][] visited;

    // (y=0) 짝수 : [0,0] [1,0] [2,0] [3,0]
    // (y=1) 홀수 :    [0,1] [1,1] [2,1] [3,1]
    // (y=2) 짝수 : [0,2] [1,2] [2,2] [3,2]
    // (y=3) 홀수 :    [0,3] [1,3] [2,3] [3,3]

    // {{짝수 ver.}, {홀수 ver.}}
    static int[][] dx = {{-1, 0, -1, 1, -1, 0}, {0, 1, -1, 1, 0, 1}};
    static int[][] dy = {{-1, -1, 0, 0, 1, 1}, {-1, -1, 0, 0, 1, 1}};

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H+2][W+2];
        for (int i = 1; i <= H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[H+2][W+2];
        System.out.println(bfs());
    }

    static int bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {0, 0});
        visited[0][0] = true;

        int cnt = 0;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();

            for (int i = 0; i < 6; i++) {
                int nx = cur[1] + dx[cur[0] % 2][i];
                int ny = cur[0] + dy[cur[0] % 2][i];

                if (ny < 0 || ny >= H + 2 || nx < 0 || nx >= W + 2) continue;

                if (map[ny][nx] == 1) cnt++;
                else if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    dq.add(new int[] {ny, nx});
                }
            }
        }

        return cnt;
    }
}