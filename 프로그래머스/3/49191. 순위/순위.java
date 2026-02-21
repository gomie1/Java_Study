class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] matchRes = new boolean[n+1][n+1];
        for (int[] res : results) {
            int A = res[0]; // winner
            int B = res[1]; // loser
            matchRes[A][B] = true; // true = win
        }
        
        // Floyd-Warshall (i: 이긴 사람, k: 중간에 껴있는 사람, j: 진 사람)
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    // i가 k를 이기고 k가 j를 이겼다면, i는 j를 이김
                    if (matchRes[i][k] && matchRes[k][j]) matchRes[i][j] = true;
                }
            }
        }
        
        // 선수 i의 순위를 알 수 있으려면, i를 제외한 나머지 n-1명과의 관계가 명확해야 함
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                // i가 j를 이겼겨나, i가 j에게 졌거나가 명확하다면 판별 가능
                if (matchRes[i][j] || matchRes[j][i]) cnt++;
            }
            
            // 본인을 제외한 모두와의 관계가 명확하다면 순위 매기기 가능!!
            if (cnt == n-1) answer++;
        }
        
        return answer;
    }
}