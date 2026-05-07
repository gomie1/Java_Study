import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int n = priorities.length;
        
        Queue<int[]> process = new LinkedList<>(); // {프로세스 번호, 우선순위}
        for (int i = 0; i < n; i++) {
            process.add(new int[] {i, priorities[i]});
        }
        
        Arrays.sort(priorities);
        
        int idx = n-1;
        int answer = 1; // 실행 횟수
        while (!process.isEmpty()) {
            int[] cur = process.poll();
            
            if (cur[1] < priorities[idx]) process.add(new int[] {cur[0], cur[1]});
            else {
                if (cur[0] == location) break;
                answer++;
                idx--;
            }
        }
        
        return answer;
    }
}