import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int N, map[][];
	static final int INF = Integer.MAX_VALUE;
	static boolean[][] visited;
	
	static class Pos implements Comparable<Pos> {
		int x, y, val;

		public Pos(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}
		
		@Override
		public int compareTo(Pos o) {
			return val - o.val;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = 1;
		while(true) {
			N = Integer.parseInt(br.readLine()); // 동굴의 크기
			if(N == 0) break;
			
			// 동굴의 도둑루피 정보 입력받기
			StringTokenizer st;
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[N][N];
			int res = dijkstra();
			System.out.println("Problem " + tc + ": " + res);
			tc++;
		}
	}

	private static int dijkstra() {
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.offer(new Pos(0, 0, map[0][0]));
		visited[0][0] = true;
		
		while(!pq.isEmpty()) {
			Pos cur = pq.poll();
			
			if(cur.x == N-1 && cur.y == N-1) {
				return cur.val;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
				
				pq.add(new Pos(nx, ny, cur.val+map[nx][ny]));
				visited[nx][ny] = true;
			}
		}
		
		return -1;
	}
}