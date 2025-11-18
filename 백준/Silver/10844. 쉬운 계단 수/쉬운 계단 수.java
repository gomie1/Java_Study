import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][10];
        Arrays.fill(dp[1], 1);
        dp[1][0] = 0;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) dp[i][j] = dp[i-1][1];
                else if (j == 9) dp[i][j] = dp[i-1][8];
                else dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];

                dp[i][j] %= MOD;
            }
        }

        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[N][i];
        }

        System.out.println(ans % MOD);
    }
}