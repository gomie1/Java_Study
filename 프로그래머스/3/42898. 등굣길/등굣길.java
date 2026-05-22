import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1]; // 각 위치별 최소 이동 횟수
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }
        
        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if ((i == 1 && j == 1) || dp[i][j] == -1) continue;
                
                // 현재 위치까지 오는 방법은 왼쪽에서 오는 방법 + 위쪽에서 오는 방법
                int left = dp[i][j-1] == -1 ? 0 : dp[i][j-1];
                int top = dp[i-1][j] == -1 ? 0 : dp[i-1][j];
                dp[i][j] = (left + top) % 1000000007;
            }
        }
        
        return dp[n][m];
    }
}