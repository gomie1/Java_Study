import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Set<Integer> carNum = new HashSet<>();
        Map<Integer, Integer> inTime = new HashMap<>(); // 입차 시각
        Map<Integer, Integer> totalTime = new HashMap<>(); // 누적 주차 시간
        
        // 1. 차량별 총 주차시간 계산
        for (String record : records) {
            String[] info = record.split(" ");
            
            int car = Integer.parseInt(info[1]);
            carNum.add(car);
            int time = timeToMin(info[0]);
            
            // 해당 차량이 입차했다면, 입차 시각 저장
            if (info[2].equals("IN")) inTime.put(car, time);
            else { // 해당 차량이 출차했다면, 주차시간 누적
                totalTime.put(car, totalTime.getOrDefault(car, 0) + (time - inTime.get(car)));
                inTime.remove(car);
            }
        }
        
        // 2. 출차 기록이 없는 차의 주차시간 계산
        int time = timeToMin("23:59");
        for (int car : inTime.keySet()) totalTime.put(car, totalTime.getOrDefault(car, 0) + (time - inTime.get(car)));
        
        // 3. 자동차별 주차 요금 계산하기 (차량 번호가 작은 것부터)
        List<Integer> car = new ArrayList<>(carNum);
        Collections.sort(car);
        
        int[] answer = new int[car.size()];
        for (int i = 0; i < car.size(); i++) {
            int cur = car.get(i);
            answer[i] = fees[1];
            
            if (totalTime.get(cur) > fees[0]) {
                int plusTime = (totalTime.get(cur) - fees[0]) / fees[2];
                if ((totalTime.get(cur) - fees[0]) % fees[2] != 0) plusTime += 1;

                answer[i] += plusTime * fees[3];
            }
        }
        
        return answer;
    }
    
    static int timeToMin(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}