import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Pos implements Comparable<Pos> {
        int idx;
        int x;
        int y;
        int order;

        public Pos(int idx, int x, int y, int order) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.order = order;
        }

        @Override
        public int compareTo(Pos o) {
            return this.order - o.order;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Pos[] pos = new Pos[N * N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                pos[idx] = new Pos(idx, i, j, 0);
                idx++;
            }
        }

        ArrayList<Pos>[] graph = new ArrayList[N*N];
        for (int i = 0; i < N*N; i++) {
            graph[i] = new ArrayList<>();
        }

        idx = 0;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N - 1; j++) {
                char s = st.nextToken().charAt(0);

                if (s == '<') {
                    graph[idx].add(pos[idx+1]);
                    pos[idx + 1].order++;
                }
                else {
                    graph[idx+1].add(pos[idx]);
                    pos[idx].order++;
                }
                idx++;
            }
            idx++;
        }

        idx = 0;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                char s = st.nextToken().charAt(0);
                if (s == '<') {
                    graph[idx].add(pos[idx+N]);
                    pos[idx + N].order++;
                }
                else {
                    graph[idx+N].add(pos[idx]);
                    pos[idx].order++;
                }

                idx++;
            }
        }

        PriorityQueue<Pos> pq = new PriorityQueue<>();
        for (int i = 0; i < N*N; i++) {
            if(pos[i].order == 0) pq.offer(pos[i]);
        }

        int[][] res = new int[N][N];
        int value = 1;
        while (!pq.isEmpty()) {
            Pos cur = pq.poll();
            res[cur.x][cur.y] = value;
            value++;

            for(Pos p : graph[cur.idx]) {
                p.order--;
                if(p.order == 0) pq.offer(p);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}