import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 1. 고속도로에서 빨리 나간 순서대로 정렬
        // -> 모든 차량이 카메라를 한 번은 만나려면 가장 빨리 고속도로를 나간 자동차부터 잡아야 함
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        int answer = 0;
        // 카메라를 설치한 마지막 위치 (어떤 자동차도 진입할 수 없는 값으로 초기화)
        int lastPos = -30001;
        for (int[] route : routes) {
            // 마지막에 설치된 카메라 위치보다 현재 자동차의 진입 지점이 더 멀다면
            // 새로운 카메라를 설치해야 함
            while (lastPos < route[0]) {
                answer++;
                lastPos = route[1];
            }
        }
        
        return answer;
    }
}