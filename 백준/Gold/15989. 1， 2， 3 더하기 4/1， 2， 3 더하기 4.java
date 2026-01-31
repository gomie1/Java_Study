import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[10001];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= 10000; i++) {
            dp[i] += dp[i-2];
        }
        for (int i = 3; i <= 10000; i++) {
            dp[i] += dp[i-3];
        }

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }

        System.out.println(sb);
    }
}