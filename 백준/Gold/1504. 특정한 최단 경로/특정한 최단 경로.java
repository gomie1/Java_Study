import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<int[]>[] graph;
    static final int INF = 200000 * 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new int[] {b, c});
            graph[b].add(new int[] {a, c});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 가능한 경우 1: 1 -> v1 -> v2 -> N
        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, N);

        // 가능한 경우 2: 1 -> v2 -> v1 -> N
        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, N);

        if (res1 >= INF && res2 >= INF) System.out.println(-1);
        else System.out.println(Math.min(res1, res2));
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        pq.offer(new int[] {start, 0});

        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[1] > dist[cur[0]]) continue;

            for (int[] nxt : graph[cur[0]]) {
                if (cur[1] + nxt[1] < dist[nxt[0]]) {
                    dist[nxt[0]] = cur[1] + nxt[1];
                    pq.offer(new int[] {nxt[0], dist[nxt[0]]});
                }
            }
        }

        return dist[end];
    }
}