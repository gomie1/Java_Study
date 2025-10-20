import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int[] price = new int[N];
            for (int i = 0; i < N; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            // 그리디 알고리즘: 역순 탐색
            // -> 주식을 팔아서 최대 이익을 내기 위해서는 주식을 산 날 이후의 가격 중 최고가에서 팔아야 함
            long ans = 0;
            int maxPrice = 0;
            for (int i = N-1; i >= 0 ; i--) {
                if (price[i] > maxPrice) maxPrice = price[i];
                else ans += (maxPrice - price[i]);
            }

            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }
}