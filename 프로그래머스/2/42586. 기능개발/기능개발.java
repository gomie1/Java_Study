import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < progresses.length; i++) {
            int d = (100 - progresses[i]) / speeds[i];
            int date = (100 - progresses[i]) % speeds[i] == 0 ? d : d+1;
            
            if (stack.isEmpty()) {
                stack.add(date);
                cnt++;
                continue;
            }
            
            if (date <= stack.peek()) cnt++;
            else {
                stack.pop();
                res.add(cnt);
                stack.add(date);
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