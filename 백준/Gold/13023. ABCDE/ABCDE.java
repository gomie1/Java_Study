import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M, res;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사람의 수
		M = Integer.parseInt(st.nextToken()); // 관계의 수
		
		graph = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		visited = new boolean[N];
		res = 0;
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i, 1);
				if(res == 1) break;
				visited[i] = false;
			}
		}
		System.out.println(res);
	}
	
	private static void dfs(int idx, int cnt) {
		if(cnt == 5) {
			res = 1;
			return;
		}
		
		for(int nxt : graph[idx]) {
			if(!visited[nxt]) {
				visited[nxt] = true;
				dfs(nxt, cnt+1);
				visited[nxt] = false;
			}
		}
	}
}