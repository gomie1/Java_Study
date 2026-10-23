import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int n = priorities.length;
        
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(new int[] {i, priorities[i]});
        }
        
        Arrays.sort(priorities);
        int idx = n-1;
        
        int answer = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            // 현재 프로세스의 우선순위가 가장 높다면
            if (cur[1] == priorities[idx]) {
                answer++; // 프로세스 실행
                idx--; // 다음으로 높은 우선순위를 가리키기 위해 인덱스 1감소
                
                if (cur[0] == location) break; // 해당 프로세스가 찾던 프로세스라면 종료
            }
            
            // 현재 프로세스보다 더 높은 우선순위를 가진 프로세스가 있다면
            // 현재 프로세스는 다시 큐에 삽입
            q.add(new int[] {cur[0], cur[1]});
        }
        
        return answer;
    }
}