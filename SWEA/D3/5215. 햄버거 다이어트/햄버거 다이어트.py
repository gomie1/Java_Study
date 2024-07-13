import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int res, N, L;
	static int[] T, K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC;
		TC = sc.nextInt(); // 테스트 케이스의 개수
		
		for(int test_case = 1; test_case <= TC; test_case++) {
			N = sc.nextInt(); // 재료의 수
			L = sc.nextInt(); // 제한 칼로리
			
			T = new int[N]; // 맛
			K = new int[N]; // 칼로리
			for(int i = 0; i < N; i++) {
				T[i] = sc.nextInt();
				K[i] = sc.nextInt();
			}
			
			res = 0;
			dfs(0, 0, 0);
			System.out.println("#" + test_case + " " + res);
		}
	}
	
	/* BackTraking */
	private static void dfs(int n, int score, int sum_kcal) {
		if(sum_kcal > L) {
			return;
		}
		
		if(n == N) { // N개의 재료를 선택했다면
			if(sum_kcal <= L) { // 현재까지의 칼로리가 제한 칼로리 이하인지 확인한 후 
				if(res < score) {
					res = score; // 가장 높은 점수 계산
				}
				return;
			}
		}
		
		dfs(n+1, score+T[n], sum_kcal+K[n]); // 현재 재료를 선택한 경우
		dfs(n+1, score, sum_kcal); // 현재 재료를 선택하지 않은 경우
	}
}