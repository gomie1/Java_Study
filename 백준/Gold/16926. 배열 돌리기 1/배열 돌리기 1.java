import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R, arr[][];
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 배열의 세로 크기
		M = Integer.parseInt(st.nextToken()); // 배열의 가로 크기
		R = Integer.parseInt(st.nextToken()); // 회전의 수
		
		arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int rep = Math.min(N, M) / 2; // 배열 내에서 회전해야하는 depth
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < rep; j++) {
				int tmp = arr[j][j];
				int x = j;
				int y = j;
				int dir = 0;
				
				while(true) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					
					if(nx < j || nx >= N-j || ny < j || ny >= M-j) {
						dir = (dir+1) % 4;
						nx = x + dx[dir];
						ny = y + dy[dir];
					}
					
					if(nx == j && ny == j) {
						arr[x][y] = tmp;
						break;
					}
					
					arr[x][y] = arr[nx][ny];
					x = nx;
					y = ny;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}