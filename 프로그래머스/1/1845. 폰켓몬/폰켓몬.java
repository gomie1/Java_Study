import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> pocketmon = new HashSet<>();
        for (int n : nums) {
            if (!pocketmon.contains(n)) pocketmon.add(n);
        }
        
        int N = nums.length / 2;
        int answer = 0;
        if (N <= pocketmon.size()) answer = N;
        else answer = pocketmon.size();
        return answer;
    }
}