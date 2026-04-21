import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Set<Integer> coin = new HashSet<>();
        for (int i = 0; i < n; i++) {
            coin.add(Integer.parseInt(br.readLine()));
        }

        int[] dp = new int[k+1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        for (int cur : coin) {
            for (int i = cur; i <= k; i++) {
                dp[i] = Math.min(dp[i], dp[i - cur] + 1);
            }
        }

        System.out.println(dp[k] == 10001 ? -1 : dp[k]);
    }
}