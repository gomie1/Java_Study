import java.io.*;
import java.util.*;

public class Main {
    static int N, M, map[][], selected[], copyMap[][], ans;
    static ArrayList<int[]> empty = new ArrayList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M]; // 0: 빈 칸, 1: 벽, 2: 바이러스
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) empty.add(new int[] {i, j});
            }
        }

        // 1. 벽을 세울 위치 3개 고르기
        selected = new int[3];
        ans = 0;
        combination(0, 0);

        System.out.println(ans);
    }

    static void combination(int start, int cnt) {
        if (cnt == 3) { // 2. 벽을 세울 3칸을 다 골랐다면, 바이러스 퍼뜨리기
            copyMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copyMap[i][j] = map[i][j];
                }
            }

            // 선택한 위치에 벽 세우기
            for (int idx : selected) {
                int x = empty.get(idx)[0];
                int y = empty.get(idx)[1];
                copyMap[x][y] = 1;
            }

            bfs(); // 바이러스 퍼뜨리기

            // 3. 안전구역 개수 카운팅
            int safe = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copyMap[i][j] == 0) safe++;
                }
            }

            ans = Math.max(ans, safe);
            return;
        }

        for (int i = start; i < empty.size(); i++) {
            selected[cnt] = i;
            combination(i+1, cnt+1);
        }
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 2) q.add(new int[] {i, j});
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || copyMap[nx][ny] != 0) continue;

                q.add(new int[] {nx, ny});
                copyMap[nx][ny] = 2;
            }
        }
    }
}