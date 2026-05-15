import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> m1 = new HashMap<>();
        m1.put(topping[0], 1);
        
        Map<Integer, Integer> m2 = new HashMap<>();
        for(int i = 1; i < topping.length; i++) {
            m2.put(topping[i], m2.getOrDefault(topping[i], 0) + 1);
        }
        
        int answer = 0;
        for (int i = 1; i < topping.length - 1; i++) {
            m1.put(topping[i], m1.getOrDefault(topping[i], 0) + 1);
            
            if (m2.get(topping[i]) <= 1) m2.remove(topping[i]);
            else m2.put(topping[i], m2.get(topping[i]) - 1);
            
            if (m1.size() == m2.size()) answer++;
        }
        
        return answer;
    }
}