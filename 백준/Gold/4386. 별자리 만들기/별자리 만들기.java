import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int to;
        double dist;

        Edge(int to, double dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        double[][] stars = new double[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            stars[i][0] = x;
            stars[i][1] = y;
        }

        // 1. 모든 별 사이의 거리를 계산하여 리스트 생성
        ArrayList<Edge>[] dists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            dists[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double d = Math.sqrt(Math.pow(stars[i][0] - stars[j][0], 2) + Math.pow(stars[i][1] - stars[j][1], 2));
                dists[i].add(new Edge(j, d));
                dists[j].add(new Edge(i, d));
            }
        }

        // 2. Prim 알고리즘
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0)); // 0번 별부터 시작

        boolean[] visited = new boolean[n];
        double ans = 0;
        int cnt = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visited[cur.to]) continue;

            visited[cur.to] = true;
            ans += cur.dist;
            if (++cnt == n) break;

            // 현재 별에서 갈 수 있는 모든 별을 pq에 추가
            for (Edge nxt : dists[cur.to]) {
                if (!visited[nxt.to]) pq.offer(nxt);
            }
        }

        System.out.printf("%.2f", ans);
    }
}