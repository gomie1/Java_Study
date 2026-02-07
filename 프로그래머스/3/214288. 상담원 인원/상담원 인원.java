import java.util.*;

class Solution {
    static int mentor[], answer;
    
    public int solution(int k, int n, int[][] reqs) {
        mentor = new int[k+1];
        Arrays.fill(mentor, 1); // 모든 유형에 적어도 1명 이상의 멘토가 있어야 함
        
        answer = Integer.MAX_VALUE;
        combination(1, 0, n-k, k, reqs); // 멘토 배치 조합 찾기
        
        return answer;
    }
    
    static void combination(int start, int cnt, int m, int k, int[][] reqs) {
        if (cnt == m) {
            // 현재 멘토 조합으로 참가자가 기다린 시간 계산하기
            calTime(k, reqs);
            return;
        }
        
        for (int i = start; i <= k; i++) {
            mentor[i]++;
            combination(i, cnt+1, m, k, reqs);
            mentor[i]--;
        }
    }
    
    static void calTime(int k, int[][] reqs) {
        // 참가자가 기다린 시간 = 상담 요청 시간 ~ 상담 시작 시간
        int[] isCounsel = new int[k+1];
        int res = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= k; i++) { // 유형은 1 ~ k번 까지
            for (int[] req : reqs) {
                if (req[2] != i) continue;
                
                if (!pq.isEmpty() && pq.peek() <= req[0]) {
                    pq.poll();
                    isCounsel[i]--;
                }
                
                // 상담할 멘토가 있는 경우
                if (isCounsel[i] < mentor[i]) {
                    pq.offer(req[0] + req[1]);
                    isCounsel[i]++;
                } else { // 상담할 멘토가 없는 경우
                    int cur = pq.poll(); // 제일 빨리 끝나는 멘토
                    res += cur - req[0]; // 대기 시간 계산
                    pq.offer(cur + req[1]); // 해당 멘토 다시 일 시키기
                }
            }
            
            pq.clear();
        }
        
        answer = Math.min(answer, res);
    }
}