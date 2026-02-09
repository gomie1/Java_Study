import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<int[]> bridge = new ArrayDeque<>(); // {트럭 번호, 거리}
        int curWeight = 0; // 현재 다리 위의 트럭 무게의 합
        int cnt = 0; // 다리를 다 건넌 트럭의 수
        int answer = 0; // 경과 시간
        
        int idx = 0; // 트럭 번호
        int n = truck_weights.length; // 트럭의 수
        while (true) {
            answer++;
            
            // 트럭 전진
            int size = bridge.size();
            for (int i = 0; i < size; i++) {
                int[] truck = bridge.poll();
                if (truck[1] + 1 > bridge_length) {
                    cnt++;
                    curWeight -= truck_weights[truck[0]];
                }
                else bridge.add(new int[] {truck[0], truck[1]+1});
            }
            
            if (cnt == n) break;
            if (idx < n && curWeight + truck_weights[idx] <= weight && bridge.size() < bridge_length) {
                bridge.add(new int[] {idx, 1});
                curWeight += truck_weights[idx++];
            }
        }
        
        return answer;
    }
}