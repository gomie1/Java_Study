import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][3];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][][] dp = new int[N][3][2]; // {x, y, (max/min)}
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j][1] = Integer.MAX_VALUE;
            }
        }
        dp[0][0][0] = dp[0][0][1] = map[0][0];
        dp[0][1][0] = dp[0][1][1] = map[0][1];
        dp[0][2][0] = dp[0][2][1] = map[0][2];

        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < 3; j++) {
                // 1. 바로 아래 수로 넘어가는 경우
                dp[i+1][j][0] = Math.max(dp[i+1][j][0], dp[i][j][0] + map[i+1][j]);
                dp[i+1][j][1] = Math.min(dp[i+1][j][1], dp[i][j][1] + map[i+1][j]);

                // 2. 바로 아래의 수와 붙어있는 수로 이동하는 경우
                if (j == 0) {
                    dp[i+1][j+1][0] = Math.max(dp[i+1][j+1][0], dp[i][j][0] + map[i+1][j+1]);
                    dp[i+1][j+1][1] = Math.min(dp[i+1][j+1][1], dp[i][j][1] + map[i+1][j+1]);
                } else if (j == 1) {
                    dp[i+1][j+1][0] = Math.max(dp[i+1][j+1][0], dp[i][j][0] + map[i+1][j+1]);
                    dp[i+1][j+1][1] = Math.min(dp[i+1][j+1][1], dp[i][j][1] + map[i+1][j+1]);
                    dp[i+1][j-1][0] = Math.max(dp[i+1][j-1][0], dp[i][j][0] + map[i+1][j-1]);
                    dp[i+1][j-1][1] = Math.min(dp[i+1][j-1][1], dp[i][j][1] + map[i+1][j-1]);
                } else {
                    dp[i+1][j-1][0] = Math.max(dp[i+1][j-1][0], dp[i][j][0] + map[i+1][j-1]);
                    dp[i+1][j-1][1] = Math.min(dp[i+1][j-1][1], dp[i][j][1] + map[i+1][j-1]);
                }
            }
        }

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, dp[N-1][i][0]);
            min = Math.min(min, dp[N-1][i][1]);
        }

        System.out.println(max + " " + min);
    }
}