import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) time[i] += 1;
        }
        
        List<Integer> res = new ArrayList<>();
        int cur = time[0];
        int cnt = 0;
        for (int t : time) {
            if (t <= cur) cnt++;
            else {
                res.add(cnt);
                cur = t;
                cnt = 1;
            }
        }
        res.add(cnt);
        
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        
        return answer;
    }
}