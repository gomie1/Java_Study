import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : scoville) pq.add(n);
        
        int answer = 0;
        while (pq.size() >= 2 && pq.peek() < K) {
            int f1 = pq.poll();
            int f2 = pq.poll();
            pq.add(f1 + f2 * 2);
            answer++;
        }
        
        if (pq.peek() < K) return -1;
        return answer;
    }
}