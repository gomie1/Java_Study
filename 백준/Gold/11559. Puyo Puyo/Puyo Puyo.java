import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static char[][] arr;
	static boolean flag, visited[][];
	static ArrayList<Integer> p;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0 ,-1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new char[12][6];
		for(int i = 0; i < 12; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		int res = 0;
		while(true) {
			p = new ArrayList<>();
			flag = false;
			visited = new boolean[12][6];
			
			for(int i = 0; i < 12; i++) {
				for(int j = 0; j < 6; j++) {
					if(arr[i][j] != '.' && !visited[i][j]) {
						bfs(i, j, arr[i][j]);
					}
				}
			}
			
			if(flag) {
				for(int y : p) {
					int idx = 11;
					boolean meetDot = false;
					for(int x = 11; x >= 0; x--) {
						if(!meetDot) {
							if(arr[x][y] == '.') meetDot = true;
							else idx--;
							continue;
						}
						else {
							if(arr[x][y] == '.') continue;
							arr[idx][y] = arr[x][y];
							arr[x][y] = '.';
							idx--;
						}
					}
				}
			}
			
			if(!flag) break;
			res++;
		}
		
		System.out.println(res);
	}
	
	private static void bfs(int x, int y, int color) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		List<int[]> pos = new ArrayList<>();
		pos.add(new int[] {x, y});
		
		int cnt = 1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx < 0 || nx >= 12 || ny < 0 || ny >= 6 || visited[nx][ny] 
						|| arr[nx][ny] == '.' || arr[nx][ny] != color) continue;
				
				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny});
				cnt++;
				pos.add(new int[] {nx, ny});
			}
		}
		
		if(cnt < 4) return;
		
		for(int[] po : pos) {
			arr[po[0]][po[1]] = '.';
			if(!p.contains(po[1])) p.add(po[1]);
		}
		flag = true;
	}
}