import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 배열의 크기
		int k = Integer.parseInt(br.readLine());
		
		long low = 1;
		long high = k;
		
		while(low < high) {
			long mid = (low + high) / 2;
			long cnt = 0;
			
			for(int i = 1; i <= N; i++) { // 구구단 i단을 의미
				cnt += Math.min(mid/i, N);
			}
			
			// lower-bound
			if(k <= cnt) {
				high = mid;
			}
			else {
				low = mid + 1;
			}
		}
		
		System.out.println(low);
	}

}