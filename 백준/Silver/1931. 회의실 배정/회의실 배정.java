import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, res;
	
	static class Meeting implements Comparable<Meeting> {
		int start;
		int end;
		
		public Meeting(int s, int e) {
			this.start = s;
			this.end = e;
		}
		
		@Override
		// 종료 시간이 빠른 순, 종료시간이 같다면 시작 시간이 빠른 순
		public int compareTo(Meeting o) {
			// this.end - o.end가 양수이면 끝나는 시간의 오름차순으로 정렬
			return this.end != o.end ? this.end - o.end : this.start - o.start;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 회의의 수
		
		// 각 회의의 시작 시간과 끝나는 시간 입력 받기
		StringTokenizer st;
		Meeting[] arr = new Meeting[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			arr[i] = new Meeting(start, end);
		}
		
		Arrays.sort(arr);
		ArrayList<Meeting> result = new ArrayList<>();
		result.add(arr[0]); // 첫 회의 스케줄에 넣기
		for(int i = 1; i < N; i++) { 
			if(result.get(result.size()-1).end <= arr[i].start) { // 마지막 회의가 다음 회의보다 빨리 끝난다면
				result.add(arr[i]); // 스케줄에 추가
			}
		}
		
		System.out.println(result.size());
	}
}
