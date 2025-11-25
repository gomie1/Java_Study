import java.io.*;

public class Main {
    static final int MOD = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();
        int n = code.length();

        // 맨 앞이 0이면 애초에 불가능한 경우이므로 예외 처리
        if (code.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        int[] dp = new int[n+1];
        dp[0] = 1; // 공집합 하나
        dp[1] = 1; // 첫 글자 하나 해석한 경우

        for (int i = 2; i <= n; i++) {
            int one = code.charAt(i-1) - '0'; // 마지막 한 글자
            int two = (code.charAt(i-2) - '0') * 10 + one; // 마지막 두 글자

            // 1. 마지막 한 글자가 해석 가능한 경우
            if (one >= 1 && one <= 9) {
                dp[i] = (dp[i] + dp[i-1]) % MOD;
            }

            // 2. 마지막 두 글자가 해석 가능한 경우
            if (two >= 10 && two <= 26) {
                dp[i] = (dp[i] + dp[i-2]) % MOD;
            }
        }

        System.out.println(dp[n] % MOD);
    }
}