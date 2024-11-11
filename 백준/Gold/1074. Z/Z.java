import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, r, c, arr[][], res;
	static int[][] Z = {{0, 1}, {1, 0}, {1, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		res = 0;
		dfs(0, 0, (int) Math.pow(2, N));		
	}

	// Point: (r, c)가 몇 사분면에 속해있는지 구하고, 그 부분만 재귀를 돌리는 것!!
	private static void dfs(int x, int y, int size) {
		if(size == 1) {
			System.out.println(res);
			return;
		}
		
		int half = size / 2;
		if(r < x+half && c < y+half) { // 1 사분면
			dfs(x, y, half);
		}
		
		if(r < x+half && y+half <= c) { // 2 사분면
			res += half*half;
			dfs(x, y+half, half);
		}
		
		if(x+half <= r && c < y+half) { // 3 사분면
			res += half*half*2;
			dfs(x+half, y, half);
		}
		
		if(x+half <= r && y+half <= c){ // 4 사분면
			res += half*half*3;
			dfs(x+half, y+half, half);
		}
	}
}