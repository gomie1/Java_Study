import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) return o2[1] - o1[1];
            if (o1[2] != o2[2]) return o2[2] - o1[2];
            if (o1[3] != o2[3]) return o2[3] - o1[3];
            return o1[0] - o2[0];
        });
        
        int limit = Math.min(minerals.length, (picks[0] + picks[1] + picks[2]) * 5);
        int idx = 1;
        int[] tmp = new int[4];
        for (int i = 0; i < limit; i++) {
            if (i != 0 && i % 5 == 0) {
                pq.add(tmp);
                tmp = new int[4];
                tmp[0] = idx++;
            }
            
            if (minerals[i].equals("diamond")) tmp[1]++;
            else if (minerals[i].equals("iron")) tmp[2]++;
            else tmp[3]++;
        }
        pq.add(tmp);
        
        int answer = 0;
        while(!pq.isEmpty()) {
            if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0) break;
            int[] cur = pq.poll();
            
            if (picks[0] != 0) {
                answer += cur[1] + cur[2] + cur[3];
                picks[0]--;
                continue;
            }
            
            if (picks[1] != 0) {
                answer += cur[1] * 5 + cur[2] + cur[3];
                picks[1]--;
                continue;
            }
            
            if (picks[2] != 0) {
                answer += cur[1] * 25 + cur[2] * 5 + cur[3];
                picks[2]--;
                continue;
            }
        }
        
        return answer;
    }
}