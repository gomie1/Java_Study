import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, res;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 사람의 수
			M = Integer.parseInt(st.nextToken()); // 관계의 수
			
			graph = new ArrayList[N+1];
			for(int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a].add(b);
				graph[b].add(a);
			}
			
			visited = new boolean[N+1];
			res = 0;
			for(int i = 1; i <= N; i++) {
				if(!visited[i]) {
					dfs(i);
					res++;
				}
			}
			System.out.println("#" + test_case + " " + res);
		}
	}
	
	/* DFS */
	private static void dfs(int n) {
		visited[n] = true;
		
		for(int node : graph[n]) {
			if(!visited[node]) {
				dfs(node);
			}
		}
	}
}
