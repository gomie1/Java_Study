import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][K+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= K; j++) {
                if (j >= W) dp[i][j] = Math.max(dp[i-1][j], V + dp[i-1][Math.max(0, j - W)]);
                else if (j < W && dp[i-1][j] > 0) dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[N][K]);
    }
}