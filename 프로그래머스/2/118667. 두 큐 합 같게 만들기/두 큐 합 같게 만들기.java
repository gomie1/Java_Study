import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long s1 = 0;
        long s2 = 0;
        
        // 1. 초기 큐 세팅 및 각 합계 계산
        for (int n : queue1) {
            q1.add(n);
            s1 += n;
        }
        
        for (int n : queue2) {
            q2.add(n);
            s2 += n;
        }
        
        // 만약 모든 원소의 합(s1+s2)이 홀수라면 정확히 반으로 나눌 수 없으므로 -1
        if ((s1 + s2) % 2 != 0) return -1;
        
        int cnt = 0;
        int maxRep = queue1.length * 3; // 최대 반복 횟수
        // * q1의 원소가 q2로 다 이동 (n번) -> q2의 원소가 다 q1으로 이동 (n번) -> q1의 원소 중 일부가 q2로 이동해서 균형을 맞춤 (1~n번) => 3n으로 지정
        while (s1 != s2) {
            if (maxRep < cnt) return -1;
            
            if (s1 > s2) {
                int val = q1.poll();
                s1 -= val;
                s2 += val;
                q2.add(val);
            } else {
                int val = q2.poll();
                s2 -= val;
                s1 += val;
                q1.add(val);
            }
            
            cnt++;
        }
        
        return cnt;
    }
}