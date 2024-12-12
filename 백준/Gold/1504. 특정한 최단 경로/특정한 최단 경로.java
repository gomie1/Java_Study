import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, E, v1, v2, dist[];
    static ArrayList<Node>[] graph;
    static final int INF = 200000 * 1000;

    static class Node implements Comparable<Node>{
        int num;
        int dist;

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수

        /* 그래프 초기화 */
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            // 양방향 연결
            graph[a].add(new Node(b, d));
            graph[b].add(new Node(a, d));
        }

        // 반드시 거쳐야 하는 두 개의 서로 다른 정점 번호 입력받기
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        // 1. 1 -> v1 -> v2 -> N 경로인 경우
        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, N);

        // 2. 1 -> v2 -> v1 -> N 경로인 경우
        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, N);

        int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);
        System.out.println(ans);
    }

    private static int dijkstra(int start, int end) {
        /* 거리 배열 초기화 */
        dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0; // 시작 노드의 거리는 0

        boolean[] visited = new boolean[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) { 
            Node cur = pq.poll();
            
            if(visited[cur.num]) continue;
            visited[cur.num] = true;

            for(Node next : graph[cur.num]) {
                if(!visited[next.num] && dist[next.num] > cur.dist + next.dist) {
                    dist[next.num] = cur.dist + next.dist;
                    pq.offer(new Node(next.num, dist[next.num]));
                }
            }
        }

        return dist[end];
    }
}