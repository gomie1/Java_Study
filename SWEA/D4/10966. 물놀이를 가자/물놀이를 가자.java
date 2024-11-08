import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, res;
	static char[][] map;
	static Queue<int[]> q;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new char[N][M];
			q = new ArrayDeque<>();
			for(int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for(int j = 0; j < M; j++) {
					// point: 물의 위치를 큐에 삽입 !!!
					if(map[i][j] == 'W') q.offer(new int[] {i, j, 0});
				}
			}
			
			res = 0;
			bfs(); // 최소 이동 횟수를 구하기 위해 BFS 사용
			System.out.println("#" + test_case + " " + res);
		}
	}
	
	private static void bfs() {
		boolean[][] visited = new boolean[N][M];
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] == 'W') continue;
				
				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny, cur[2]+1});
				res += cur[2]+1;
			}
		}
	}
}