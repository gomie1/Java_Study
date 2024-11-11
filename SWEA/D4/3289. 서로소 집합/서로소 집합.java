import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, parents[];
	static String res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			parents = new int[n+1];
			for(int i = 1; i <= n; i++) {
				parents[i] = i;
			}
			
			res = "";
			sb.append("#" + test_case + " ");
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(num == 0) union(a, b);
				else {
					if(findSet(a) == findSet(b)) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot != bRoot) {
			parents[bRoot] = aRoot;
		}
	}
	
	private static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
}