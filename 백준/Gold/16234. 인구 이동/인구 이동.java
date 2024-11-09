import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, L, R, map[][], sum, cnt;
	static int[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 땅의 크기
		L = Integer.parseInt(st.nextToken()); // 인구차이는 L 이상
		R = Integer.parseInt(st.nextToken()); // R 이하
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int res = 0;
		while(true) {
			visited = new int[N][N];
			int flag = 1;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(visited[i][j] == 0) {
						sum = map[i][j];
						cnt = 0;
						bfs(i, j, flag);
						flag++;
					}
				}
			}
			if(flag == N*N+1) break;
			res++;
		}
		
		System.out.println(res);
	}
	
	private static void bfs(int x, int y, int v) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = v;
		cnt++;
		List<int[]> arr = new ArrayList<>(); 
		arr.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] > 0) continue;
				
				if(Math.abs(map[cur[0]][cur[1]] - map[nx][ny]) >= L && Math.abs(map[cur[0]][cur[1]] - map[nx][ny]) <= R) {
					visited[nx][ny] = v;
					q.offer(new int[] {nx, ny});
					sum += map[nx][ny];
					cnt++;
					arr.add(new int[] {nx, ny});
				}
			}
		}
		
		if(cnt == 1) return;
		
		int value = sum / cnt;
		for(int[] pos : arr) {
			map[pos[0]][pos[1]] = value;
		}
	}
}