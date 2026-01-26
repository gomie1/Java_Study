import java.io.*;
import java.util.*;

public class Main {
    static int K, files[], sum[], dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            K = Integer.parseInt(br.readLine());
            if (K == 1) {
                sb.append(0).append('\n');
                continue;
            }

            files = new int[K+1];
            sum = new int[K+1]; // 누적합
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                sum[i] += sum[i-1] + files[i];
            }

            dp = new int[K+1][K+1]; // i번째 파일부터 j번째 파일까지 합치는 데 드는 최소 비용
            for (int i = 1; i <= K; i++) {
                Arrays.fill(dp[i], -1);
            }

            sb.append(dfs(1, K)).append('\n');
        }

        System.out.println(sb);
    }

    static int dfs(int start, int end) {
        if (start == end) return 0;
        if (dp[start][end] != -1) return dp[start][end];

        int min = Integer.MAX_VALUE;
        int curSum = sum[end] - sum[start-1];
        for (int k = start; k < end; k++) {
            int cost = dfs(start, k) + dfs(k+1, end) + curSum;
            min = Math.min(min, cost);
        }

        return dp[start][end] = min;
    }
}