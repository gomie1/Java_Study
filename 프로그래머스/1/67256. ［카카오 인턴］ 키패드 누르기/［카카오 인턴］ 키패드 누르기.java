import java.util.*;

class Solution {
    static int[][] pos = { // 0 ~ 9까지의 위치 정보
        {3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, 
        {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2} 
    };
    static StringBuilder sb = new StringBuilder();
    static int lx, ly, rx, ry;
    
    public String solution(int[] numbers, String hand) {
        // 초기 왼손 위치('*')
        lx = 3; 
        ly = 0;
        
        // 초기 오른손 위치('#')
        rx = 3;
        ry = 2;
        
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            
            if (n == 1 || n == 4 || n == 7) moveLeft(n);
            else if (n == 3 || n == 6 || n == 9) moveRight(n);
            else {
                double l_dist = Math.ceil(Math.sqrt(Math.pow((lx - pos[n][0]), 2) + Math.pow((ly - pos[n][1]), 2)));
                double r_dist = Math.ceil(Math.sqrt(Math.pow((rx - pos[n][0]), 2) + Math.pow((ry - pos[n][1]), 2)));
                
                if (l_dist < r_dist || ((l_dist == r_dist) && hand.equals("left")))  moveLeft(n);
                else if (l_dist > r_dist || ((l_dist == r_dist) && hand.equals("right"))) moveRight(n);
            }
        }
        
        return sb.toString();
    }
    
    static void moveLeft(int n) {
        sb.append("L");
        lx = pos[n][0];
        ly = pos[n][1];
    }
    
    static void moveRight(int n) {
        sb.append("R");
        rx = pos[n][0];
        ry = pos[n][1];
    }
}