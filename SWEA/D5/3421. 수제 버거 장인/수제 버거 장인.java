import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	private static int N, M, isSelected[], res;
	private static boolean[][] info;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			M = Integer.parseInt(st.nextToken()); // 궁합이 맞지 않는 재료 쌍의 수
			
			// 궁합이 맞지 않는 재료 쌍의 정보 입력 받기
			info = new boolean[N+1][N+1];
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				info[a][b] = true;
				info[b][a] = true;
			}
			
			res = 0;
			isSelected = new int[N+1];
			dfs(1);
			System.out.println("#" + test_case + " " + res);
		}
	}

	private static boolean check(int cnt, int select) {
		for(int i = 1; i <= cnt; i++) {
			if(isSelected[i] == 0) continue;
			if(info[select][isSelected[i]]) return false;
		}
		
		return true;
	}
	
	private static void dfs(int cnt) {
		if(cnt == N+1) {
			res++;
			return;
		}
		
		// 현재 재료를 선택하지 않는 경우
		isSelected[cnt] = 0;
		dfs(cnt+1);
		
		// 현재 재료를 선택하는 경우
		if(check(cnt, cnt)) {
			isSelected[cnt] = cnt;
			dfs(cnt+1);
			isSelected[cnt] = 0;
		}
	}
}