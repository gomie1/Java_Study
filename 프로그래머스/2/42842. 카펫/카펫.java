import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        int[] answer = {};
        for (int h = 3; h <= total; h++) {
            if (total % h == 0) {
                int w = total / h;
                
                if (w >= h) {
                    if ((w-2) * (h-2) == yellow) {
                        answer = new int[] {w, h};
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}