import java.io.*;

public class Main {
    static final int MOD = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i-1] + dp[i-2] * 2) % MOD;
        }

        System.out.println(dp[N] % MOD);
    }
}