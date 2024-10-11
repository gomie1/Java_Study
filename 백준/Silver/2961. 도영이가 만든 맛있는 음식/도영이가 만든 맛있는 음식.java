import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, S[], B[], res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 재료의 개수
		
		StringTokenizer st;
		S = new int[N]; // 신맛
		B = new int[N]; // 쓴맛
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken()); 
			
			S[i] = s;
			B[i] = b;
		}
		
		res = Integer.MAX_VALUE;
		dfs(0, 1, 0);
		System.out.println(res);
	}
	
	private static void dfs(int cnt, int sum_s, int sum_b) {
		if(cnt == N) {
			if(sum_s == 1 && sum_b == 0) return; // 아무 재료도 선택하지 않은 경우는 패스
			
			// 최소값 찾기
			int value = Math.abs(sum_s - sum_b);
			if(res > value) res = value; 
			return;
		}
		
		// 현재 재료를 선택하지 않는 경우
		dfs(cnt+1, sum_s, sum_b);
		
		// 현재 재료를 선택하는 경우
		dfs(cnt+1, sum_s*S[cnt], sum_b+B[cnt]);
	}
}