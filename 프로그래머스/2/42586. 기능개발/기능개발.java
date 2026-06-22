import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        
        // 1. 각 프로세스 처리 시간 계산
        int[] time = new int[n]; // [7, 3, 9]
        for (int i = 0; i < n; i++) {
            int t = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] == 0) time[i] = t;
            else time[i] = t + 1;
        }
        
        // 2. 작업 시작
        List<Integer> res = new ArrayList<>();
        for (int cur = 0; cur < n; cur++) {
            int cnt = 1;
            
            int nxt = cur + 1;
            while (nxt < n && time[nxt] <= time[cur]) {
                cnt++;
                nxt++;
            }
            
            res.add(cnt);
            cur = nxt - 1;
        }
        
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        
        return answer;
    }
}