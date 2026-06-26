class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        int[][] t = new int[n][n+1];
        for (int i = 0; i < n; i++) {
            int j = 1;
            for (int v : triangle[i]) {
                t[i][j++] = v;
            }
        }
        
        int[][] dp = new int[n][n+1];
        dp[0][1] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= triangle[i].length; j++) {
                // 왼쪽 위에서 오거나, 바로 위에서 오거나
                int max = Math.max(dp[i-1][j-1], dp[i-1][j]);
                dp[i][j] = max + triangle[i][j-1];
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[n-1][i]);
        }
        
        return answer;
    }
}