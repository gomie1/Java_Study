import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, map[][], dist[][];

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Pos implements Comparable<Pos> {
        int x;
        int y;
        int cnt;

        public Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pos o) {
            return this.cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로 크기
        N = Integer.parseInt(st.nextToken()); // 세로 크기

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        dijkstra();
        System.out.println(dist[N-1][M-1]);
    }

    private static void dijkstra() {
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        pq.offer(new Pos(0, 0, 0));

        while(!pq.isEmpty()) {
            Pos cur = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if(cur.cnt + map[nx][ny] < dist[nx][ny]) {
                    dist[nx][ny] = cur.cnt + map[nx][ny];
                    pq.offer(new Pos(nx, ny, dist[nx][ny]));
                }
            }
        }
    }
}