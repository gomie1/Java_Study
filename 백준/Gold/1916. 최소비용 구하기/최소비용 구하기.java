import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, dist[];
    static ArrayList<Bus>[] graph;
    static boolean[] visited;

    static class Bus implements Comparable<Bus> {
        int city;
        int cost;

        public Bus(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 도시의 수
        M = Integer.parseInt(br.readLine()); // 버스의 수

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Bus(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        dijkstra(startNode);
        System.out.println(dist[endNode]);
    }

    private static void dijkstra(int start) {
        // 거리 배열 초기화
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0; // 본인과의 거리는 0

        // 방문 배열 초기화
        visited = new boolean[N+1];

        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.offer(new Bus(start, 0)); // 시작 노드 큐에 삽입

        while(!pq.isEmpty()) {
            Bus cur = pq.poll();

            if(visited[cur.city]) continue;
            visited[cur.city] = true;

            for(Bus next : graph[cur.city]) { // 현재 마을과 연결된 마을을 모두 탐색
                if(dist[cur.city] + next.cost < dist[next.city]) { // 현재 마을을 거쳐서 다음 마을로 가는 비용이 더 작다면 비용 갱신
                    dist[next.city] = dist[cur.city] + next.cost;
                    pq.offer(new Bus(next.city, dist[next.city]));
                }
            }
        }
    }
}