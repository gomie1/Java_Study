import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken()); // 시작 정점 번호
		
		// ArrayList 2차원 배열 선언
		graph = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		// 정점들 연결 (양방향)
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		// 방문할 수 있는 정점이 여러 개인 경우 정점 번호가 작은 것부터 방문하기 위해 그래프 정렬
		for(int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}
		
		visited = new boolean[N+1];
		dfs(V);
		sb.append("\n");
		
		visited = new boolean[N+1];
		bfs(V);
		System.out.println(sb);
	}

	private static void dfs(int cur) {
		visited[cur] = true; // 현재 정점 방문처리
		sb.append(cur + " ");
		
		for(int vertex : graph[cur]) { // 현재 정점과 연결된 정점들에 대해 하나씩 순회
			if(!visited[vertex]) { // 연결된 정점에 방문한 적이 없다면
				dfs(vertex); // 재귀를 통해 해당 정점으로 이동
			}
		}
	}
	
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>(); // 큐 생성
		queue.add(start); // 시작 노드를 큐에 삽입
		visited[start] = true; // 시작 노드 방문 처리
		
		// 큐가 비었다 = 더이상 연결된 정점이 없다는 뜻이므로
		// 큐가 비어있지 않은 동안 반복
		while(!queue.isEmpty()) {
			int vertex = queue.poll(); // 현재 정점을 큐에서 꺼냄
			sb.append(vertex + " ");
			
			// 현재 정점과 연결된 정점 수만큼 반복
			for(int i = 0; i < graph[vertex].size(); i++) {
				int next = graph[vertex].get(i); // 현재 정점과 연결된 정점
				
				if(!visited[next]) { // 연결된 노드에 방문한 적이 없다면
					visited[next] = true; // 방문처리 후
					queue.add(next); // 큐에 삽입
				}
			}
		}
	}
}
