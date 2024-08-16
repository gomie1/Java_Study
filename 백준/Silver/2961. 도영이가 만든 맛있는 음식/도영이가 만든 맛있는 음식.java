import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, S[], B[], res;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 재료의 개수
		
		// 신맛과 쓴맛 입력 받기
		StringTokenizer st;
		S = new int[N];
		B = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		// 재료의 개수가 1개이면 바로 결과를 출력하고 종료
		if(N == 1) {
			System.out.println(Math.abs(S[0] - B[0]));
			return;
		}
		
		// 재료의 개수가 2개 이상인 경우
		isSelected = new boolean[N];
		res = Integer.MAX_VALUE;
		cooking(0, 1, 0);
		
		System.out.println(res);
	}

	private static void cooking(int cnt, int s, int b) {
		if(cnt == N) { // 종료 조건
			if(s != 1 && b != 0) { // 1개 이상의 재료를 선택했다면
				res = Math.min(res, Math.abs(s - b)); // 최소값 산출
			}
			return;
		}
		
		// 현재 재료를 선택하는 경우
		isSelected[cnt] = true;
		cooking(cnt+1, s*S[cnt], b+B[cnt]);
		
		// 현재 재료를 선택하지 않은 경우
		isSelected[cnt] = false;
		cooking(cnt+1, s, b);
	}
}
