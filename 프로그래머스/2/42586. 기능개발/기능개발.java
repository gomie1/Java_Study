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
        int nxt = 1;
        int t = time[0];
        int cnt = 1;
        while (nxt < n) {
            if (time[nxt] <= t) cnt++;
            else {
                res.add(cnt);
                t = time[nxt];
                cnt = 1;
            }
            
            nxt++;
        }
        res.add(cnt);
        
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) answer[i] = res.get(i);
        return answer;
    }
}