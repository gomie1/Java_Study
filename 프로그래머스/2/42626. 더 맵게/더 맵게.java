import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : scoville) pq.add(n);
        
        // 이미 모든 음식의 스코빌 지수가 K이상인 경우, 섞을 필요 없음
        if (pq.peek() >= K) return 0;
        
        int answer = 0;
        while (pq.size() > 1) {
            pq.add(pq.poll() + (pq.poll() * 2));
            answer++;
            if (pq.peek() >= K) return answer;
        }
        
        return -1;
    }
}