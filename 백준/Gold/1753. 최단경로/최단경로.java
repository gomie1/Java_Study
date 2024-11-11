import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, K, dist[];
	static ArrayList<Edge>[] graph;
	
	static class Edge implements Comparable<Edge> {
		int num;
		int weight;
		
		public Edge(int num, int weight) {
			super();
			this.num = num;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수
		K = Integer.parseInt(br.readLine()); // 시장 정점의 번호
		
		graph = new ArrayList[V+1];
		for(int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Edge(v, w));
		}
		
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;
		
		Dijkstra();
		for(int i = 1; i <= V; i++) {
			System.out.println(dist[i] != Integer.MAX_VALUE ? dist[i] : "INF");
		}
	}

	private static void Dijkstra() {
		boolean[] visited = new boolean[V+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(K, 0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(visited[cur.num]) continue;
			visited[cur.num] = true;
			
			for(Edge nxt : graph[cur.num]) {
				if(dist[nxt.num] > dist[cur.num] + nxt.weight) {
					dist[nxt.num] = dist[cur.num] + nxt.weight;
					pq.offer(new Edge(nxt.num, dist[nxt.num])); 
					// 갱신된 거리를 넣어주는 이유: 넣어주지 않으면 nxt.num의 weight는 계속 초기 가중치가 되기 때문
				}
			}
		}
	}
}