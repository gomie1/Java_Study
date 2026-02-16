import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> mapIn = new HashMap<>();
        HashMap<String, Integer> mapSum = new HashMap<>();
        
        StringTokenizer st;
        for (String record : records) {
            st = new StringTokenizer(record);
            String[] time = st.nextToken().split(":");
            int minute = 60 * Integer.parseInt(time[0]) + Integer.parseInt(time[1]);
            String car = st.nextToken();
            String status = st.nextToken();
            
            if (status.equals("IN")) mapIn.put(car, minute);
            else {
                int inTime = mapIn.get(car);
                mapSum.put(car, mapSum.getOrDefault(car, 0) + (minute - inTime));
                mapIn.remove(car);
            }
        }
        
        for (String key : mapIn.keySet()) {
            mapSum.put(key, mapSum.getOrDefault(key, 0) + (1439 - mapIn.get(key)));
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        for (String key : mapSum.keySet()) {
            int t = mapSum.get(key);
            if (t <= fees[0]) pq.offer(new int[] {Integer.parseInt(key), fees[1]});
            else {
                int tmp = 0;
                if ((t - fees[0]) % fees[2] == 0) tmp = (int) (t - fees[0]) / fees[2];
                else tmp = (int) ((t - fees[0]) / fees[2]) + 1;
                
                int fee = fees[1] + (tmp * fees[3]);
                pq.offer(new int[] {Integer.parseInt(key), fee});
            }
        }
        
        int[] answer = new int[mapSum.size()];
        for (int i = 0; i < mapSum.size(); i++) {
            answer[i] = pq.poll()[1];
        }
        return answer;
    }
}