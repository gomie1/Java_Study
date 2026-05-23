import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int left = 200000001;
        int right = 0;
        for (int stone : stones) {
            left = Math.min(left, stone);
            right = Math.max(right, stone);
        }
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            int cnt = 0;
            int max = 0;
            for (int stone : stones) {
                if (stone <= mid) cnt++;
                else {
                    if (cnt != 0) {
                        max = Math.max(max, cnt);
                        cnt = 0;
                    }
                }
            }
            
            // 끝까지 건너뛰는 경우도 포함하기 위함
            max = Math.max(max, cnt);
            
            if (k <= max) right = mid - 1;
            else left = mid + 1;
        }
        
        return left;
    }
}