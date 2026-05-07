import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int n = truck_weights.length; // 트럭의 개수
        Deque<int[]> bridge = new ArrayDeque<>(); // {트럭 번호, 이동 거리}
        int curWeight = 0; // 현재 다리 위 트럭의 총 무게
        int answer = 0; // 소요 시간
        
        int truck = 0; // 트럭 번호
        while (true) {
            answer++;
            
            // 트럭 이동
            int size = bridge.size();
            for (int i = 0; i < size; i++) {
                int[] cur = bridge.poll();
                
                // 현재 트럭이 아직 다리를 다 건너지 않았다면 한 칸 이동
                if (cur[1] < bridge_length) bridge.add(new int[] {cur[0], cur[1]+1});
                else curWeight -= truck_weights[cur[0]]; // 다리를 다 건넜다면 내리기
            }
            
            // 대기 트럭이 진입할 수 있다면 진입
            if (truck < n && bridge.size() < bridge_length && curWeight + truck_weights[truck] <= weight) {
                bridge.add(new int[] {truck, 1});
                curWeight += truck_weights[truck++];
            }
            
            if (truck >= n && bridge.isEmpty()) break;
        }
        
        return answer;
    }
}