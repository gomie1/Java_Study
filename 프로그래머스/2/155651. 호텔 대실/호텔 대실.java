import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        // 1. 시간을 String to Integer로 전환하기
        int[][] time = new int[book_time.length][4]; // {시작시, 시작분, 종료시, 종료분}
        for (int i = 0; i < book_time.length; i++) {
            String[] start = book_time[i][0].split(":");
            time[i][0] = Integer.parseInt(start[0]);
            time[i][1] = Integer.parseInt(start[1]);
            
            String[] end = book_time[i][1].split(":");
            time[i][2] = Integer.parseInt(end[0]);
            time[i][3] = Integer.parseInt(end[1]);
        }
        
        Arrays.sort(time, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            if (o1[2] != o2[2]) return o1[2] - o2[2];
            return o1[3] - o2[3];
        });
        
        PriorityQueue<int[]> finish = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        finish.add(calTime(time[0][2], time[0][3]));
        int answer = 1;
        for (int i = 1; i < book_time.length; i++) {
            // 가장 빨리 비는 방의 사용 가능 시각이 현재 방의 예약 시각보다 늦다면, 방 새로 생성
            if (time[i][0] < finish.peek()[0] || (time[i][0] == finish.peek()[0] && time[i][1] < finish.peek()[1])) {
                answer++;
                finish.add(calTime(time[i][2], time[i][3]));
            } else { // 현재 예약 시각에 빈 방이 있다면, 해당 방 사용
                finish.poll();
                finish.add(calTime(time[i][2], time[i][3]));
            }
        }
        
        return answer;
    }
    
    static int[] calTime(int h, int m) {
        int[] t = new int[2];
        
        if (m + 10 >= 60) {
            t[0] = h + 1;
            t[1] = m + 10 - 60;
        } else {
            t[0] = h;
            t[1] = m + 10;
        }
        
        return t;
    }
}