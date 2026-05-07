import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int rep = (int) Math.sqrt(yellow);
        for (int row = 1; row <= rep; row++) { // yellow 열 개수 (세로)
            if (yellow % row != 0) continue;
            
            int col = yellow / row; // yellow 행 개수 (가로)
            int boldCnt = col * 2 + row * 2 + 4;
            if (brown == boldCnt) {
                answer[0] = col + 2;
                answer[1] = row + 2;
                break;
            }
        }
        
        return answer;
    }
}