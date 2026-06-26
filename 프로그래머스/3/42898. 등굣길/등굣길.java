import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // dp[i][j]: (i, j)까지 갈 수 있는 방법의 수
        // -> dp[i][j] = (위쪽에서 오는 방법의 수) + (왼쪽에서 오는 방법의 수)
        int[][] dp = new int[n][m];
        
        boolean[][] isPossible = new boolean[n][m];
        for (int[] p : puddles) isPossible[p[1]-1][p[0]-1] = true;
        
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 && j == 0) || isPossible[i][j]) continue;
                
                if (i == 0) dp[i][j] = dp[i][j-1];
                else if (j == 0) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
                
                dp[i][j] %= 1000000007;
            }
        }
        
        return dp[n-1][m-1] % 1000000007;
    }
}