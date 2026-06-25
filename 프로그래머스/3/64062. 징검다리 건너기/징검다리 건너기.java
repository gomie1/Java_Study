import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int left = 1; // 징검다리를 건널 수 있는 최소 인원 수
        int right = 0; // 징검다리를 건널 수 있는 최대 인원 수 = stones의 최대값 (다 0이 되어서 건널 수 없어짐)
        for (int stone : stones) right = Math.max(right, stone);
        
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            
            int jumpCnt = 0;
            for (int stone : stones) {
                // 해당 돌을 mid명이 건널 수 없다면 건너뛰기
                if (stone - mid < 0) jumpCnt++;
                else jumpCnt = 0; // 해당 돌을 mid명이 건널 수 있다면, 건너뛴 횟수 초기화
                
                // k보다 더 많이 건너뛰는 것은 불가능하므로 종료
                if (jumpCnt == k) break;
            }
            
            // mid명이 건널 수 있다면, 인원 수 늘려보기 (최대 인원수를 구하는 것이므로)
            if (jumpCnt < k) {
                answer = mid; // 정답 후보 저장
                left = mid + 1;
            }
            else right = mid - 1; // mid명은 건널 수 없다면, 인원 수 줄이기
        }
        
        return answer;
    }
}