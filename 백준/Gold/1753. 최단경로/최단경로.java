import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        ArrayList<int[]>[] graph = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new int[] {v, w});
        }

        int[] dist = new int[V+1];
        Arrays.fill(dist, INF);
        dist[K] = 0;

        // Dijkstra
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[] {K, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll(); // [v, w]
            if (dist[cur[0]] < cur[1]) continue; // 더 가까운 거리가 있다면 pass

            for (int[] nxt : graph[cur[0]]) {
                if (cur[1] + nxt[1] < dist[nxt[0]]) {
                    dist[nxt[0]] = cur[1] + nxt[1];
                    pq.offer(new int[] {nxt[0], dist[nxt[0]]});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) sb.append("INF").append('\n');
            else sb.append(dist[i]).append('\n');
        }

        System.out.println(sb);
    }
}