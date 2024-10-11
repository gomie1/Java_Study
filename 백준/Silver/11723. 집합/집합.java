import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine()); // 연산의 수
		StringTokenizer st;
		int bit = 0;
		StringBuilder sb = new StringBuilder();
		while(M-- != 0) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int x = 0;
			if(!str.equals("all") && !str.equals("empty")) x = Integer.parseInt(st.nextToken());
			
			switch(str) {
			case "add":
				if((bit & (1 << x)) == 0) bit = bit + (1 << x);
				break;
			case "remove":
				if((bit & (1 << x)) != 0) bit = bit - (1 << x);
				break;
			case "check":
				if((bit & (1 << x)) != 0) sb.append(1 + "\n");
				else sb.append(0 + "\n");
				break;
			case "toggle":
				if((bit & (1 << x)) != 0) bit = bit - (1 << x);
				else bit = bit + (1 << x);
				break;
			case "all":
				bit = (1 << 21) - 1;
				break;
			case "empty":
				bit = 0;
				break;
			}
		}
		
		System.out.println(sb.toString());
	}
}