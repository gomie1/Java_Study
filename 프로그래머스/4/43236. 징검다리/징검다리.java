import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        // 바위 사이의 거리를 계산해야 하므로, 무조건 정렬되어 있어야 함!
        Arrays.sort(rocks);
        
        int left = 1; // 최소 거리
        int right = distance; // 최대 거리
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2; // 바위 사이의 최소 거리
            
            int cur = 0; // 시작 위치
            int removeRock = 0; // 제거한 돌의 개수
            for (int rock : rocks) {
                // 현재 위치에서 다음 바위까지의 거리가 mid보다 작다면 해당 바위 제거
                if (rock - cur < mid) removeRock++;
                else cur = rock; // 거리가 mid 이상이라면, 다음 바위로 이동
                
                // 이미 n개보다 많은 바위를 제거했다면 종료
                if (removeRock > n) break;
            }
            
            // 마지막 바위부터 도착점까지의 거리 체크
            if (distance - cur < mid) removeRock++;
            
            // n개 이하의 바위를 제거했다면, 거리를 더 늘려보기 (최소값 중 최대값을 찾아야 하므로)
            if (removeRock <= n) {
                left = mid + 1;
                answer = mid;
            }
            else right = mid - 1; // n개보다 많은 바위를 제거했다면 거리를 줄여 최소값 찾기
        }
        
        return answer;
    }
}