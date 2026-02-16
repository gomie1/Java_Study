import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int answer = 0;
        if (set.size() < nums.length / 2) answer = set.size();
        else answer = nums.length / 2;
        return answer;
    }
}