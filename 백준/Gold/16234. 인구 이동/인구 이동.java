import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R, map[][], visited[][];
    static boolean flag;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move());
    }

    static int move() {
        int day = 0;
        visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }

        while (true) {
            flag = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] != day) {
                        checkGroup(i, j, day);
                    }
                }
            }

            if (!flag) break;
            day++;
        }

        return day;
    }

    static void checkGroup(int x, int y, int num) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {x, y});
        visited[x][y] = num;

        ArrayList<int[]> group = new ArrayList<>(); // 연합국 위치 리스트
        int sum = 0;
        int cnt = 0;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            group.add(new int[] {cur[0], cur[1]});
            sum += map[cur[0]][cur[1]];
            cnt++;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] == num) continue;

                int diff = Math.abs(map[cur[0]][cur[1]] - map[nx][ny]);
                if (diff < L || diff > R) continue;

                visited[nx][ny] = num;
                dq.offer(new int[] {nx, ny});
            }
        }

        if (cnt == 1) return;

        // 연합 (인구 이동)
        flag = true;
        int val = sum / cnt;
        for (int i = 0; i < cnt; i++) {
            int[] cur = group.get(i);
            map[cur[0]][cur[1]] = val;
        }
    }
}