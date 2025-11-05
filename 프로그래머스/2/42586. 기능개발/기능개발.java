import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 1. 각 작업별 완성하기까지 걸리는 시간 계산하기
        int[] days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) days[i] = (100 - progresses[i]) / speeds[i];
            else days[i] = ((100 - progresses[i]) / speeds[i]) + 1;
        }
        
        int idx = 0;
        int maxDay = days[idx++];
        int cnt = 1;
        List<Integer> cntList = new ArrayList<>();
        while (idx < days.length) {
            if (days[idx] <= maxDay) cnt++;
            else {
                cntList.add(cnt);
                cnt = 1;
                maxDay = days[idx];
            }
            
            idx++;
        }
        cntList.add(cnt);
        
        int[] ans = new int[cntList.size()];
        for (int i = 0; i < cntList.size(); i++) {
            ans[i] = cntList.get(i);
        }
        
        return ans;
    }
}