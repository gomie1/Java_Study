import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            dq.add(new int[] {i, priorities[i]});
        }
        Arrays.sort(priorities);
        int idx = priorities.length - 1;
        
        int answer = 0;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            
            if (cur[1] < priorities[idx]) dq.addLast(new int[] {cur[0], cur[1]});
            else {
                answer++;
                idx--;
                if (cur[0] == location) break;
            }
        }
        
        return answer;
    }
}