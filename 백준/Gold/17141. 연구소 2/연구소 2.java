import java.io.*;
import java.util.*;

public class Main {
    static int N, M, zero, map[][], virus[][], ans;
    static ArrayList<int[]> pos = new ArrayList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        zero = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0) zero++;
                if (map[i][j] == 2) {
                    pos.add(new int[] {i, j});
                    map[i][j] = 0;
                    zero++;
                }
            }
        }

        zero -= M;
        virus = new int[M][2];
        ans = Integer.MAX_VALUE;
        select(0, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void select(int start, int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                map[virus[i][0]][virus[i][1]] = 2;
            }

            ans = Math.min(ans, spread());

            for (int i = 0; i < M; i++) {
                map[virus[i][0]][virus[i][1]] = 0;
            }

            return;
        }

        for (int i = start; i < pos.size(); i++) {
            virus[cnt] = pos.get(i);
            select(i+1, cnt+1);
        }
    }

    static int spread() {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < M; i++) {
            dq.offer(new int[] {virus[i][0], virus[i][1], 0});
            visited[virus[i][0]][virus[i][1]] = true;
        }

        int time = 0;
        int cnt = 0;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            time = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                dq.offer(new int[] {nx, ny, cur[2]+1});
                cnt++;
            }
        }

        return cnt == zero ? time : Integer.MAX_VALUE;
    }
}