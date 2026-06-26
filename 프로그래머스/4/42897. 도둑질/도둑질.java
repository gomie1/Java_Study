import java.util.*;

class Solution {
    public int solution(int[] money) {
        int n = money.length;
        
        // 1. 첫 집을 터는 경우
        int[] dp1 = new int[n];
        dp1[0] = money[0]; // 첫 집을 턴다고 가정
        dp1[1] = money[0]; // 따라서 두 번째 집은 절대 털 수 없음
        for (int i = 2; i < n-1; i++) { // 첫 집을 털기에 마지막 집은 털 수 없음 (n-2까지)
            // 현재 집을 털지 않는 경우: 이전 집까지의 최대값
            // 현재 집을 터는 경우: 전전집까지의 최대값 + 현재 집에서 털 돈
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
        }
        
        // 2. 첫 집을 털지 않는 경우
        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = money[1];
        for (int i = 2; i < n; i++) { // 첫 집을 털지 않기에 마지막 집을 털 수 있음 (n-1까지)
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }
        
        return Math.max(dp1[n-2], dp2[n-1]);
    }
}