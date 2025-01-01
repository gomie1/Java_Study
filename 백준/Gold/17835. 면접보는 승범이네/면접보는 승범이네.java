import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int city;
        long cost;

        public Node(int city, long cost) {
            this.city = city;
            this.cost = cost;
        }


        @Override
        public int compareTo(Node o) {
            return Long.compare(cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시의 수
        int M = Integer.parseInt(st.nextToken()); // 도로의 수
        int K = Integer.parseInt(st.nextToken()); // 면접장의 수

        ArrayList<Node>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken()); // from
            int V = Integer.parseInt(st.nextToken()); // to
            long C = Long.parseLong(st.nextToken()); // cost

            graph[V].add(new Node(U, C));
        }

        long[] dist = new long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE);

        /* Djikstra */
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            int start = Integer.parseInt(st.nextToken());
            pq.offer(new Node(start, 0));
            dist[start] = 0;
        }

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(dist[cur.city] < cur.cost) continue;

            for (Node nxt : graph[cur.city]) {
                if(cur.cost + nxt.cost < dist[nxt.city]) {
                    dist[nxt.city] = cur.cost + nxt.cost;
                    pq.offer(new Node(nxt.city, dist[nxt.city]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Node ans = new Node(0, 0);
        for (int i = 1; i <= N; i++) {
            if(ans.cost < dist[i]) {
                ans.city = i;
                ans.cost = dist[i];
            }
        }
        sb.append(ans.city).append('\n').append(ans.cost);
        bw.write(sb.toString());
        bw.close();
    }
}