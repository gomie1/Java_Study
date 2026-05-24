import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] isWin = new boolean[n+1][n+1];
        for (int[] result : results) {
            isWin[result[0]][result[1]] = true;
        }
        
        // 플로이드 워셜 (i가 k를 이기고, k가 j를 이기면 -> i는 j를 이긴다)
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (isWin[i][k] && isWin[k][j]) isWin[i][j] = true;
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int cnt1 = 0; // i가 이긴 선수의 수
            int cnt2 = 0; // i가 진(= i를 이긴) 선수의 수
            for (int j = 1; j <= n; j++) {
                if (isWin[i][j]) cnt1++;
                if (isWin[j][i]) cnt2++;
            }
            
            // i가 모든 상대 선수와의 경기 결과를 가졌다면 순위를 매길 수 있음
            if (cnt1 + cnt2 == n-1) answer++;
        }
        
        return answer;
    }
}