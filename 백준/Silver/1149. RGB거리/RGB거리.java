import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        int[][] costs = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] dp = new int[N][3]; // i번째 집까지 드는 각 컬러별 최소 비용
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (k == j) continue;
                    dp[i][k] = Math.min(dp[i][k], dp[i-1][j] + costs[i][k]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[N-1][i]);
        }
        System.out.println(min);
    }
}