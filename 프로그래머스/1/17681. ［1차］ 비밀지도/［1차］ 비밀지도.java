import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[][] map1 = makeMap(n, arr1);
        int[][] map2 = makeMap(n, arr2);
        
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (map1[i][j] == 0 && map2[i][j] == 0) sb.append(" ");
                else sb.append("#");
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
    
    static int[][] makeMap(int n, int[] arr) {
        int[][] map = new int[n][n];
        
        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder();
            int num = arr[i];
            for(int k = 0; k < n; k ++) {
                sb.append(num % 2);
                num /= 2;
            }
            
            String binary = sb.reverse().toString();
            for (int j = 0; j < n; j++) {
                map[i][j] = binary.charAt(j) - '0';
            }
        }
        
        return map;
    }
}