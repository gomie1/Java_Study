import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        int answer = triangle[0][0];
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < i+1; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i+1][j+k] = Math.max(dp[i+1][j+k], dp[i][j] + triangle[i+1][j+k]);
                    answer = Math.max(answer, dp[i+1][j+k]);
                }
            }
        }
        
        return answer;
    }
}