import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, box[][], tCnt, cnt, res;
	static Queue<int[]> q = new LinkedList<>();
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		box = new int[M][N]; // 0: 익지 않은 토마토, 1: 익은 토마토, -1: 빈 칸
		tCnt = 0; // 총 토마토의 개수
		cnt = 0; // 익은 토마토의 개수
		visited = new boolean[M][N];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1) {
					tCnt++;
					q.offer(new int[] {i, j}); // 익은 토마토의 위치를 큐에 삽입
					visited[i][j] = true;
				}
				
				if(box[i][j] == 0) tCnt++;
			}
		}
		
		cnt = q.size();
		res = 0;
		bfs();
		//System.out.println("tCnt = " + tCnt + ", cnt = " + cnt);
		System.out.println(cnt == tCnt ? res-1 : -1);
	}
	
	private static void bfs() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int[] cur = q.poll();
				
				
				for(int j = 0; j < 4; j++) {
					int nx = cur[0] + dx[j];
					int ny = cur[1] + dy[j];
					
					if(nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny] || box[nx][ny] == -1 || box[nx][ny] == 1) continue;
					
					//System.out.println("nx = " + nx + ", ny = " + ny);
					visited[nx][ny] = true;
					cnt++;
					q.offer(new int[] {nx, ny});
					
				}
			}
			
			res++;
		}
	}
}