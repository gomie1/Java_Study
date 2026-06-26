import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> in = new HashMap<>(); // <차량번호, 입차시간>
        Map<String, Integer> parkTime = new HashMap<>(); // <차량번호, 누적 주차 시간>
        
        // 입/출차 시간 계산
        for (String record : records) {
            String[] info = record.split(" ");
            
            if (info[2].equals("IN")) in.put(info[1], timeToMin(info[0]));
            else {
                int outTime = timeToMin(info[0]); // 출차 시간
                int totalTime = outTime - in.get(info[1]); // 주차 시간
                parkTime.put(info[1], parkTime.getOrDefault(info[1], 0) + totalTime);
                
                // 현재 차량을 입차 차량에서 삭제
                in.remove(info[1]);
            }
        }
        
        // 출차된 내역이 없는 차량에 대해 23:59 출차로 누적 시간 계산
        int finalTime = timeToMin("23:59");
        for (String key : in.keySet()) {
            int totalTime = finalTime - in.get(key); // 주차 시간
            parkTime.put(key, parkTime.getOrDefault(key, 0) + totalTime);
        }
        
        // 차량 번호가 작은 자동차부터 청구해야 하므로 keySet을 만들고 정렬
        String[] keys = new String[parkTime.size()];
        int idx = 0;
        for (String key : parkTime.keySet()) {
            keys[idx++] = key;
        }
        
        Arrays.sort(keys);
        
        int[] answer = new int[parkTime.size()];
        idx = 0;
        for (String key : keys) {
            int t = parkTime.get(key); // 현재 차량의 총 주차 시간
            
            // 누적 주차 시간이 기본 시간 이하라면, 기본 요금 청구
            if (t <= fees[0]) answer[idx++] = fees[1];
            else { // 기본 시간을 초과하면, 기본 요금에 더해서 초과한 시간에 대해 단위 시간마다 단위 요금을 청구
                int plusTime = (t - fees[0]) / fees[2];
                if ((t - fees[0]) % fees[2] != 0) plusTime += 1; // 초과한 시간이 단위 시간으로 나누어 떨어지지 않으면 올림 처리
                answer[idx++] = fees[1] + (plusTime * fees[3]);
            }
        }
        
        return answer;
    }
    
    static int timeToMin(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3, 5));
        return hour * 60 + min;
    }
}