import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            String str1 = o1 + o2;
            String str2 = o2 + o1;
            return str2.compareTo(str1);
        });
        int sum = 0;
        for (int n : numbers) {
            pq.offer(Integer.toString(n));
            sum += n;
        }
        
        String answer = "";
        if (sum == 0) answer = "0";
        else {
            while (!pq.isEmpty()) answer += pq.poll();
        }
        return answer;
    }
}