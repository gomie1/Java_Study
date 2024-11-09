import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, C, house[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 집의 개수
		C = Integer.parseInt(st.nextToken()); // 공유기의 개수
		
		// 집의 좌표 입력 받기
		house = new int[N];
		for(int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house); // 집의 좌표 정렬
		
		int low = 1;
		int high = house[N-1] - house[0] + 1;
		while(low < high) {
			int mid = (low + high) / 2; // mid가 최소 거리를 의미함
			
			if(isPossible(mid) < C) {
				high = mid;
			}
			else {
				low = mid + 1;
			}
		}
		
		System.out.println(low-1);
	}
	
	private static int isPossible(int dist) {
		int last = house[0]; // 마지막에 설치한 집 번호 표시
		int cnt = 1; // 설치한 공유기의 수
		
		for(int i = 1; i < N; i++) {
			if(house[i] - last < dist) continue;
			else {
				last = house[i];
				cnt++;
			}
		}
		
		return cnt;
	}
}