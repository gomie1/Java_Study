import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 1. end(진출 시점)를 기준으로 정렬
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        // 2. 가장 먼저 나가는 차량의 진출 시점에 카메라 설치
        int answer = 0;
        int camera = routes[0][1];
        answer++;
        
        int n = routes.length;
        for(int i = 1; i < n; i++) {
            // 현재 차량의 진입(start) 시점이 이전 차량의 진출(end) 시점보다 전이면 
            // 해당 차량 구간에는 따로 카메라를 설치하지 않아도 됨 
            if(routes[i][0] <= camera) continue;
            else { 
                // 이전 차량과 현재 차량의 구간이 겹치지 않는 경우 
                // 현재 차량의 진출 시점에 카메라 설치
                camera = routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}