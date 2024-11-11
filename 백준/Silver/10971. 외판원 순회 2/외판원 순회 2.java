import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, W[][], start, res;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 도시의 수
		
		W = new int[N][N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N];
		res = Integer.MAX_VALUE;
		
		// 모든 도시를 기준으로 여행을 시작하기 위한 반복문
		for(int i = 0; i < N; i++) {
			start = i;
			visited[i] = true;
			dfs(1, 0, start);
			visited[i] = false;
		}
		
		System.out.println(res);
	}
	
	private static void dfs(int cnt, int sum, int prev) {
		// 가지치기 : 비용의 최소값을 찾는 것이기 때문에 비용이 이미 현재 결과보다 크다면 종료
		if(sum > res) { 
			return;
		}
		
		// 모든 도시를 다 방문했다면 
		// 마지막 도시에서 처음 도시로 돌아가는 비용을 합산한 비용으로 최소값 산출
		if(cnt == N) {
			if(W[prev][start] != 0) {
				res = Math.min(res, sum+W[prev][start]);
			}
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i] && W[prev][i] != 0) {
				visited[i] = true;
				dfs(cnt+1, sum+W[prev][i], i);
				visited[i] = false;
			}
		}
	}

}