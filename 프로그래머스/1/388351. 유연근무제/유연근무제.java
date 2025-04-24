class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int idx = 0;
        for(int i = 0; i < schedules.length; i++) {
            int h = schedules[i] / 100;
            int m = (schedules[i] % 100) + 10;
            if(m >= 60) {
                h += 1;
                m -= 60;
            }
            int time = h*100 + m;
            
            boolean isLate = false;
            for(int j = 0; j < 7; j++) {
                int day = (startday + j) % 7;
                if(day >= 1 && day < 6 && timelogs[i][j] > time) isLate = true;
            }

            if(!isLate) answer++;
        }
        return answer;
    }
}