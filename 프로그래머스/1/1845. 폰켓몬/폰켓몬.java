import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> pocketmon = new HashSet<>();
        for (int n : nums) {
            if (!pocketmon.contains(n)) pocketmon.add(n);
        }
        
        return Math.min(nums.length / 2, pocketmon.size());
    }
}