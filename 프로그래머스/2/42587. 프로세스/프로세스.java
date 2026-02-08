import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            dq.add(new int[] {i, priorities[i]});
        }
        
        Arrays.sort(priorities);
        int idx = priorities.length - 1;
        
        int answer = 0;
        while (true) {
            int[] cur = dq.pollFirst();
            
            if (cur[1] < priorities[idx]) dq.addLast(cur);
            else {
                idx--;
                answer++;
                if (cur[0] == location) break;
            }
        }
        
        return answer;
    }
}