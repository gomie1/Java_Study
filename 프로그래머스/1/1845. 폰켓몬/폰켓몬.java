import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);    
        }
        
        int total = nums.length / 2;
        ArrayDeque<Integer> chosen = new ArrayDeque<>();
        int cnt = 0;
        
        while (cnt < total) {
            List<Integer> keys = new ArrayList<>(map.keySet());
            for (int n : keys) {
                if (!chosen.contains(n)) chosen.add(n);
                if (++cnt == total) break;
                
                if (map.get(n) == 1) map.remove(n);
                else map.put(n, map.get(n) - 1);
            }
        }
        
        return chosen.size();
    }
}