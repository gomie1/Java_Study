import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int to;
        long weight;

        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        long[][] map = new long[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Long.parseLong(st.nextToken());
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0));

        boolean[] visited = new boolean[N];
        int cnt = 0;
        long ans = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visited[cur.to]) continue;

            visited[cur.to] = true;
            ans += cur.weight;
            if (++cnt == N) break;

            for (int i = 0; i < N; i++) {
                if (cur.to != i && !visited[i]) pq.offer(new Edge(i, map[cur.to][i]));
            }
        }

        System.out.println(ans);
    }
}