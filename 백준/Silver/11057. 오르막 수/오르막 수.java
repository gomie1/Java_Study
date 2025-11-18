import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][10];
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= N; i++) {
            dp[i][9] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 8; j >= 0; j--) {
                dp[i][j] = (dp[i-1][j] + dp[i][j+1]) % 10007;
            }
        }

        long ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += dp[N][i];
        }

        System.out.println(ans % 10007);
    }
}