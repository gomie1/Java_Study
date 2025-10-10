import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int lastDeliveryIdx = n - 1; // 배달할 물건이 남아있는 가장 먼 집의 인덱스
        int lastPickupIdx = n - 1; // 수거할 물건이 남아있는 가장 먼 집의 인덱스
        
        // 배달과 수거 중 하나라도 남은 집이 있다면 반복
        while (lastDeliveryIdx >= 0 || lastPickupIdx >= 0) {
            // 1. 가장 마지막 집부터 배달 or 수거가 0인 집을 건너뛰어 실제로 작업이 필요한 가장 먼 집 찾기
            while (lastDeliveryIdx >= 0 && deliveries[lastDeliveryIdx] == 0) lastDeliveryIdx--;
            while (lastPickupIdx >= 0 && pickups[lastPickupIdx] == 0) lastPickupIdx--;
            
            // 2. 운행 거리 결정
            // * 왕복 거리는 배달과 수거 중 더 먼 곳의 거리를 기준으로 함
            int curMaxIdx = Math.max(lastDeliveryIdx, lastPickupIdx);
            if (curMaxIdx < 0) break;
            answer += (curMaxIdx + 1) * 2; // 왕복 거리 추가
            
            // 3. 배달 처리
            int curCap = cap;
            int idx = lastDeliveryIdx;
            for (int i = idx; i >= 0; i--) {
                if (deliveries[i] <= curCap) {
                    curCap -= deliveries[i];
                    deliveries[i] = 0;
                } else {
                    deliveries[i] -= curCap;
                    curCap = 0; // 트력 용량 full
                    break;
                }
            }
            
            // 4. 수거 처리
            curCap = cap;
            idx = lastPickupIdx;
            for (int i = idx; i >= 0; i--) {
                if (pickups[i] <= curCap) {
                    curCap -= pickups[i];
                    pickups[i] = 0;
                } else {
                    pickups[i] -= curCap;
                    curCap = 0; // 트력 용량 full
                    break;
                }
            }
            
        }
        
        return answer;
    }
}