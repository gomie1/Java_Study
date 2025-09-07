import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfEnd = new int[100]; // 날짜별 배포 개수를 기록할 배열
        int day = 0;
        for(int i = 0; i < progresses.length; i++) {
            // 기능 i가 끝나는 날짜를 구함
            while(progresses[i] + (day * speeds[i]) < 100) {
                day++;
            }
            
            // i번째 기능은 'day'날짜에 완료되므로 해당 날짜 카운트 증가
            dayOfEnd[day]++;
        }
        
        // 0이 아닌 값만 추출해서 결과 배열로 반환
        return Arrays.stream(dayOfEnd).filter(i -> i != 0).toArray();
    }
}