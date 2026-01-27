import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[31][31];
        for (int n = 0; n <= 30; n++) {
            for (int r = 0; r <= n; r++) {
                if (r == 0 || r == n) {
                    dp[n][r] = 1; // nC0과 nCn은 항상 1
                    continue;
                }
                // 파스칼의 삼각형: mCn = m-1Cn-1 + m-1Cn
                dp[n][r] = dp[n-1][r-1] + dp[n-1][r];
            }
        }

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(dp[M][N]).append('\n');
        }

        System.out.println(sb);
    }
}