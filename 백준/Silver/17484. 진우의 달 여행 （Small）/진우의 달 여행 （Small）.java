import java.io.*;
import java.util.*;

public class Main {
    static class Travel implements Comparable<Travel> {
        int x;
        int y;
        int dir;
        int price;


        public Travel(int x, int y, int dir, int price) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.price = price;
        }

        @Override
        public int compareTo(Travel o) {
            return this.price - o.price;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] mtrx = new int[N][M];
        int ans = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                mtrx[i][j] = Integer.parseInt(st.nextToken());
                ans += mtrx[i][j];
            }
        }

        // BFS
        int[] dy = {-1, 0, 1};

        PriorityQueue<Travel> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            pq.offer(new Travel(0, i, -1, mtrx[0][i]));
        }

        while (!pq.isEmpty()) {
            Travel cur = pq.poll();
            if (cur.x == N-1) {
                System.out.println(cur.price);
                break;
            }

            for (int i = 0; i < 3; i++) {
                if (cur.dir == i) continue;

                int nx = cur.x + 1;
                int ny = cur.y + dy[i];

                if (nx >= N || ny < 0 || ny >= M) continue;
                pq.offer(new Travel(nx, ny, i, cur.price + mtrx[nx][ny]));
            }
        }
    }
}