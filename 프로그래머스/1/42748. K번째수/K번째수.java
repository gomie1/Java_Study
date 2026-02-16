import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int cur = 0; cur < commands.length; cur++) {
            int i = commands[cur][0] - 1;
            int j = commands[cur][1] - 1;
            int k = commands[cur][2] - 1;
            
            int[] subArr = new int[j-i+1];
            int idx = 0;
            for (int n = i; n <= j; n++) {
                subArr[idx++] = array[n];
            }
            
            Arrays.sort(subArr);
            answer[cur] = subArr[k];
        }
        
        return answer;
    }
}