import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int res = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 전체 사람의 수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n+1];
		for(int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int m = Integer.parseInt(br.readLine()); // 관계의 개수
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph[x].add(y);
			graph[y].add(x);
		}
		
		visited = new boolean[n+1];
		bfs(p1, p2);
		System.out.println(res);
	}
	
	private static void bfs(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start); // 시작 노드 큐에 삽입
		visited[start] = true; // 시작 노드 방문처리
		
		// res를 바로 ++시키는 식으로 처리하면 
		// 모든 탐색이 끝났는데 end를 만나지 못한 경우에도 
		// bfs를 반복한 만큼의 수가 들어가서 -1이 되지 못함
		int depth = 0; 
		loop: while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				int cur = queue.poll();
				
				if(cur == end) {
					res = depth;
					break loop;
				}
				
				for(int p : graph[cur]) {
					if(!visited[p]) {
						visited[p] = true;
						queue.offer(p);
					}
				}
			}
			depth++;
		}
	}
}