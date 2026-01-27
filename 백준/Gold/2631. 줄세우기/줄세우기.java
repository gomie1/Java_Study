import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N]; // i번째 아이를 마지막으로 포함하는 LIS 길이
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }

//        for (int i = 0; i < N; i++) {
//            System.out.print(dp[i] + " ");
//        }
//        System.out.println();
        System.out.println(N - max);
    }
}