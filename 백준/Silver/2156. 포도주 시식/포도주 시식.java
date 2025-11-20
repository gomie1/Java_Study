import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] wine = new int[n];
        for (int i = 0; i < n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(wine[0]);
            return;
        }

        if (n == 2) {
            System.out.println(wine[0] + wine[1]);
            return;
        }

        int[] dp = new int[n];
        dp[0] = wine[0];
        dp[1] = wine[0] + wine[1];
        dp[2] = Math.max(
                Math.max(dp[1], wine[0] + wine[2]), // 2번째 와인을 마시지 않는 경우 vs 0번째, 2번째 와인을 마시는 경우
                wine[1] + wine[2] // vs 1번째, 2번째 와인을 마시는 경우
        );

        int max = Math.max(dp[1], dp[2]);
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(
                    Math.max(dp[i-1], dp[i-2] + wine[i]),
                    dp[i-3] + wine[i-1] + wine[i]
            );

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}