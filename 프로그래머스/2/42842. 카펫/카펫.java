import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int i = 1; i <= (int) Math.sqrt(yellow); i++) {
            if (yellow % i == 0 && brown == countBrown(yellow, i)) {
                answer[0] = (yellow / i) + 2;
                answer[1] = i + 2;
                break;
            }
        }
        
        return answer;
    }
    
    static int countBrown(int yellow, int line) {
        return line * 2 + (yellow / line) * 2 + 4;
    }
}