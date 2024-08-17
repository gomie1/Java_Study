import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 숫자의 자릿 수
		
		int[] primeNumber = {2, 3, 5, 7};
		for(int n : primeNumber) {
			dfs(n, 1);
		}
	}
	
	private static boolean isPrime(int num) {
		// 2이하의 수는 소수가 아님
		if(num < 2) return false;
		
		// num의 제곱근 이하의 수로 나누어지는 수가 있으면 소수가 아님
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) return false;
		}
		
		return true;
	}
	
	private static void dfs(int num, int cnt) {
		if(cnt == N) { // N자리 수를 만들었고,
			if(isPrime(num)) { // 그 숫자가 소수라면
				System.out.println(num); // 출력
			}
			
			return;
		}
		
		// 각 자릿수에 올 수 있는 숫자는 1 ~ 9이므로 모든 경우에 대해 반복
		for(int i = 1; i <= 9; i++) {
			if(i % 2 == 0) {
				continue; // 끝자리가 짝수이면 소수가 아니기 때문에 continue
			}
			
			if(isPrime(num*10 + i)) {
				dfs(num*10 + i, cnt+1);
			}
		}
	}
}
