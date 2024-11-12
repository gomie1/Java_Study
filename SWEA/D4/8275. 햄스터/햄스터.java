import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, X, cage[], res[], count;
	static ArrayList<int[]> info;
	static boolean isFind;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); 
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			info = new ArrayList<>();
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				info.add(new int[] {l, r, s});
			}
			
			cage = new int[N+1];
			res = new int[N+1];
			isFind = false;
			count = 0;
			permutation(1, 0);
			
			if(isFind) {
				System.out.print("#" + test_case + " ");
				for(int i = 1; i <= N; i++) {
					System.out.print(res[i] + " ");
				}
				System.out.println();
			}
			else {
				System.out.println("#" + test_case + " -1");
			}
		}
	}
	
	// 중복 순열
	private static void permutation(int idx, int cnt) { // idx: 우리 번호, cnt: 햄스터 수
		if(idx == N+1) {
			int flag = 0;
			for(int[] cur : info) { // cur[0]: l, cur[1]: r, cur[2]: s
				int sum = 0;
				for(int i = cur[0]; i <= cur[1]; i++) {
					sum += cage[i];
				}
                
				if(sum != cur[2]) return;
			}
			
			if(count < cnt || cnt == 0) {
				isFind = true;
				res = cage.clone();
				count = cnt;
			}
			return;
		}
		
		for(int i = 0; i <= X; i++) {
			cage[idx] = i;
			permutation(idx+1, cnt+cage[idx]);
		}
	}
}