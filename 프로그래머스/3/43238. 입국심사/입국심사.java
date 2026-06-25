/* 조건 1) n의 크기가 터무니 없이 큼
   조건 2) 최소값을 찾아야 함
   => 이분탐색!! */
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        // 최소 시간: 사람이 1명이 가장 짧게 걸리는 심사대로 가는 경우
        long left = times[0];
        // 최대 시간: 사람 n명이 모두 가장 오래 걸리는 심사대로 가는 경우
        long right = (long) times[times.length - 1] * n;
        while (left < right) {
            long mid = (left + right) / 2;
            
            // mid분 동안 n명을 심사할 수 있는지 확인
            // 모든 심사관이 mid분 동안 각각 몇 명씩 심사할 수 있는지의 합 >= n
            long cnt = 0;
            for (long t : times) {
                cnt += mid / t;
            }
            
            // mid분 안에 n명 이상 심사를 할 수 있다면, 시간을 줄여 더 작은 값으로도 되는지 확인
            if (cnt >= n) right = mid;
            else left = mid + 1; // mid분 안에 n명 이상 심사를 할 수 없다면, 시간 늘리기
        }
        
        return left;
    }
}