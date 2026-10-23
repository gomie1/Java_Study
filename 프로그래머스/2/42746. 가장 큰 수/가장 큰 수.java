import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s2.compareTo(s1);
        });
        
        for (int num : numbers) pq.add(Integer.toString(num));
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) sb.append(pq.poll());
        String answer = sb.toString();
        
        return answer.startsWith("0") ? "0" : answer;
    }
}