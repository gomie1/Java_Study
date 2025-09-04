import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> tmp = new ArrayList<>();
        int preNum = 10;
        for (int n : arr) {
            if (preNum != n) tmp.add(n);
            preNum = n;
        }
        
        int[] answer = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            answer[i] = tmp.get(i);
        }
        
        return answer;
    }
}