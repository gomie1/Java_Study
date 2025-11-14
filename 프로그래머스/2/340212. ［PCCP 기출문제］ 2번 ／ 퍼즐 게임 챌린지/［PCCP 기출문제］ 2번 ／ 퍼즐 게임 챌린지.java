class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int low = 1;
        int high = 0;
        for (int i = 0; i < diffs.length; i++) {
            high = Math.max(high, diffs[i]);
        }
        
        while (low < high) {
            int mid = (low + high) / 2;
            long time = game(diffs, mid, times);
            
            if (time <= limit) high = mid;
            else low = mid + 1;
        }
        
        return low;
    }
    
    static long game(int[] diffs, int level, int[] times) {
        long t = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) t += times[i];
            else t += (times[i] + times[i-1]) * (diffs[i] - level) + times[i];
        }
        
        return t;
    }
}