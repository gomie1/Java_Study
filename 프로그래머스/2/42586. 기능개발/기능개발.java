import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        int time = 0;
        int cnt = 1;
        ArrayList<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < len; i++) {
            int val = 100 - progresses[i];
            
            if (val % speeds[i] == 0) val /= speeds[i];
            else val = (val / speeds[i]) + 1;
            
            if (i == 0) {
                time = val;
                continue;
            }
            
            if (val <= time) cnt++;
            else {
                res.add(cnt);
                cnt = 1;
                time = val;
            }
        }
        res.add(cnt);
        
        int size = res.size();
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }
}