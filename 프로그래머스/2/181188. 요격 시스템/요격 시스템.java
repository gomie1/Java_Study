import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        // 1. 모든 미사일 데이터를 끝나는 시간(e)를 기준으로 오름차순 정렬
        Arrays.sort(targets, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        // 2. 미사일들을 하나씩 확인하면서, 현재 미사일이 끝나는 지점(e) 직전에 요격 미사일을 한 발 쏨
        int answer = 0;
        double lastPos = -1; // 마지막으로 요격 미사일을 쏜 위치 (초기값은 어떤 미사일보다도 앞선 -1로 설정)
        
        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];
            
            // 현재 미사일의 시작 지점이 마지막 요격 위치보다 뒤에 있다면
            // 기존 요격 미사일로는 이 미사일을 맞출 수 없으므로 새로 쏴야 함
            if (start >= lastPos) {
                answer++;
                // 개구간이므로 end 지점 자체는 포함 안됨 -> end 직전에 쏘는 것!
                // 정수 연산만 안전하게 하기 위해, 미사일의 실제 위치를 end로 잡고
                // 조건문을 start >= lastPos로 두면 실수 연산 오차 없이 동작함
                lastPos = end;
            }
        }
        
        return answer;
    }
}