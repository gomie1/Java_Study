import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 준서가 버틸 수 있는 무게

        int[] dp = new int[K+1]; // dp[i] = 배낭에 ikg까지 담을 수 있을 때, 가치의 최대값
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            // 경우는 배낭에 현재 물건을 넣는 경우와 안넣는 경우 2가지가 존재
            // ex. 물건의 무게가 3, 가치가 6인 상황 -> dp[7] = 현재 물건을 넣는 경우(dp[7-3] + 6)와 안넣는 경우(dp[7]) 중 큰 값으로 선택
            for (int j = K; j >= weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight] + value);
            }
        }

        System.out.println(dp[K]);
    }
}