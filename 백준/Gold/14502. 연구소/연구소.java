import java.io.*;
import java.util.*;

public class Main {
    static int N, M, map[][], pos[][], copyMap[][], ans;
    static ArrayList<int[]> zero;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M]; // 0: 빈 칸, 1: 벽, 2: 바이러스
        zero = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) zero.add(new int[] {i, j});
            }
        }

        pos = new int[3][2];
        ans = 0;
        combination(0, 0);
        System.out.println(ans);
    }

    static void combination(int cnt, int start) {
        if (cnt == 3) {
            // 바이러스 퍼뜨리기
            copyMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copyMap[i][j] = map[i][j];
                }
            }

            // 벽 세우기
            for (int i = 0; i < 3; i++) {
                copyMap[pos[i][0]][pos[i][1]] = 1;
            }

            // 안전구역 찾기
            ans = Math.max(ans, findSafe());

            // 원상복구
            for (int i = 0; i < 3; i++) {
                map[pos[i][0]][pos[i][1]] = 0;
            }
            return;
        }

        for (int i = start; i < zero.size(); i++) {
            pos[cnt] = zero.get(i);
            combination(cnt+1, i+1);
        }
    }

    static int findSafe() {
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 2 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        // 안전 구역 개수 카운팅
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    static void bfs(int sx, int sy) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {sx, sy});
        visited[sx][sy] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || copyMap[nx][ny] != 0) continue;
                q.offer(new int[] {nx, ny});
                copyMap[nx][ny] = 2;
                visited[nx][ny] = true;
            }
        }
    }
}