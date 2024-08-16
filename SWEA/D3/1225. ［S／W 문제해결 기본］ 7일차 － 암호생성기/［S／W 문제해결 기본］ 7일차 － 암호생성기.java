import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		for(int test_case = 0; test_case < 10; test_case++) {
			int tc = Integer.parseInt(br.readLine()); // 테스트 케이스의 번호
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Integer> queue = new LinkedList<>(); // 큐 생성
			for(int i = 0; i < 8; i++) { // 큐에 8개의 데이터 삽입
				queue.add(Integer.parseInt(st.nextToken()));
			}
			
			int cnt = 1;
			while(true) {
				if(cnt > 5) { // 1 사이클을 돌았다면
					cnt = 1; // 다시 1로 초기화
				}
				
				int data = queue.poll(); // 큐의 가장 첫 번쨰 원소를 꺼낸 후
				int res = data - cnt; // cnt만큼 감소
				if(res <= 0) { // 감소시킨 결과가 0보다 작거나 같다면
					queue.add(0); // 큐에 0을 삽입한 후
					break; // 반복 종료
				}
				
				queue.add(data - cnt); // 감소시킨 결과가 0보다 크다면 그 값을 큐에 삽입
				cnt++; // cnt 1 증가
			}
			
            // 출력
			System.out.print("#" + tc + " ");
			for(int d : queue) {
				System.out.print(d + " ");
			}
			System.out.println();
		}
	}
}