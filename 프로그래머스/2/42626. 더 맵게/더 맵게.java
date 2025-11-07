import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // 1. 모든 음식의 스코빌 지수를 우선순위 큐에 삽입 (정렬)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : scoville) {
            pq.add(n);
        }
        
        // 2. 이미 모든 음식의 스코빌 지수가 K 이상이라면 0반환 후 종료
        if (pq.peek() >= K) return 0;
        
        // 3. 음식 섞기
        int answer = 0;
        while (pq.size() >= 2 && pq.peek() < K) {
            int a = pq.poll();
            int b = pq.poll();
            
            int mix = a + b*2;
            answer++;
            pq.add(mix);
        }
        
        if (pq.peek() >= K) return answer;
        else return -1;
    }
}