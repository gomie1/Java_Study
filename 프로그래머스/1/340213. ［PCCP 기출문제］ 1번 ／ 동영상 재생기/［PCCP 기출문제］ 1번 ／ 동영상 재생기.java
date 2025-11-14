class Solution {
    static int[] opTime;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 1. 모든 시간을 초로 변환
        int curTime = Integer.parseInt(pos.split(":")[0]) * 60 + Integer.parseInt(pos.split(":")[1]);
        int opStart = Integer.parseInt(op_start.split(":")[0]) * 60 + Integer.parseInt(op_start.split(":")[1]);
        int opEnd = Integer.parseInt(op_end.split(":")[0]) * 60 + Integer.parseInt(op_end.split(":")[1]);
        int endTime = Integer.parseInt(video_len.split(":")[0]) * 60 + Integer.parseInt(video_len.split(":")[1]);
        
        // 2. 시작 위치가 오프닝 구간이라면 현재 위치를 오프닝이 끝나는 위치로 이동
        if (opStart <= curTime && curTime <= opEnd) curTime = opEnd;
        
        StringBuilder sb = new StringBuilder();
        for (String cmd : commands) {
            if (cmd.equals("prev")) {
                curTime -= 10;
                if (curTime < 0) curTime = 0;
            } else if (cmd.equals("next")) {
                curTime += 10;
                if (curTime > endTime) curTime = endTime;
            }
            
            // 현재 위치가 오프닝 범위일 경우 오프닝 건너뛰기 (오프닝이 끝나는 위치로 이동)
            if (opStart <= curTime && curTime <= opEnd) curTime = opEnd;
        }
        
        int m = curTime / 60;
        if (m < 10) sb.append(0);
        sb.append(m).append(":");
        
        int s = curTime % 60;
        if (s < 10) sb.append(0);
        sb.append(s);
        
        return sb.toString();
    }
}