import java.io.*;
import java.util.*;

public class Main {
    static int N, map[][], shark;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        map = new int[N][N];
        int x = 0, y = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 상어의 초기 위치
                if (map[i][j] == 9) {
                    x = i;
                    y = j;
                }
            }
        }

        map[x][y] = 0;
        System.out.println(babyShark(x, y));
    }

    static int babyShark(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y}); // 아기 상어의 초기 위치

        shark = 2; // 아기 상어의 초기 크기
        int cnt = 0; // 아기 상어가 잡아먹은 물고기 수
        int time = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            // 1. 먹을 수 있는 물고기 찾기
            PriorityQueue<int[]> fishLst = findFish(cur[0], cur[1]);
            if (fishLst.isEmpty()) break; // 먹을 수 있는 물고기가 없다면 종료!!

            // 2. 아기 상어 이동
            int[] fish = fishLst.poll();
            q.offer(new int[] {fish[0], fish[1]});
            time += fish[2];

            // 3. 물고기 잡아먹기
            map[fish[0]][fish[1]] = 0;
            cnt++;

            // 4. 아기 상어가 자신의 크기만큼 물고기를 잡아먹었다면 크기 1증가
            if (cnt == shark) {
                shark++;
                cnt = 0;
            }
        }

        return time;
    }

    static PriorityQueue<int[]> findFish(int sx, int sy) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {sx, sy, 0});
        boolean[][] visited = new boolean[N][N];
        visited[sx][sy] = true;

        PriorityQueue<int[]> fishes = new PriorityQueue<>((o1, o2) -> { // {x, y, 거리}
            if (o1[2] != o2[2]) return o1[2] - o2[2]; // 거리순 정렬
            if (o1[0] != o2[0]) return o1[0] - o2[0]; // 거리가 같다면 가장 위에 있는 물고기
            return o1[1] - o2[1]; // 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기
        });

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] > shark) continue;

                visited[nx][ny] = true;
                dq.offer(new int[] {nx, ny, cur[2]+1});
                if (map[nx][ny] >= 1 && map[nx][ny] <= 6 && map[nx][ny] < shark) fishes.offer(new int[] {nx, ny, cur[2]+1});
            }
        }

        return fishes;
    }
}