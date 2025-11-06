import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            dq.add(new int[] {priorities[i], i});
        }
        
        Arrays.sort(priorities);
        
        int answer = 0;
        int idx = priorities.length - 1;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            
            if (cur[0] < priorities[idx]) dq.add(new int[] {cur[0], cur[1]});
            else {
                answer++;
                idx--;
                if (cur[1] == location) break;
            }
        }
        
        return answer;
    }
}