import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int fee[], plan[], res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			fee = new int[4]; // day, month, 3month, year
			for(int i = 0; i < 4; i++) {
				fee[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			plan = new int[13];
			for(int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			res = Integer.MAX_VALUE;
			dfs(1, 0);
			System.out.println("#" + test_case + " " + res);
		}
	}
	
	private static void dfs(int idx, int sum) {
		if(idx > 12) {
			res = Math.min(res, sum);
			return;
		}
		
		// 현재 달에 수영장을 다닐 계획이 없다면 요금을 낼 필요가 없음
		if(plan[idx] == 0) {
			dfs(idx+1, sum);
		}
		else {
			// 1. 현재 달을 1일 이용권으로 다니기
			dfs(idx+1, sum+(plan[idx]*fee[0]));
			
			// 2. 현재 달을 1달 이용권으로 다니기
			dfs(idx+1, sum+fee[1]);
			
			// 3. 현재 달을 3달 이용권으로 다니기
			dfs(idx+3, sum+fee[2]);
			
			// 4. 현재 달을 1년 이용권으로 다니기
			dfs(idx+12, sum+fee[3]);
		}
	}
}