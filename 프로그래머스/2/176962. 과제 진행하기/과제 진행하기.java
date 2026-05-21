import java.util.*;

class Solution {
    public String[] solution(String[][] plans) { // [name, start, playtime]
        int n = plans.length; // 과제 수
        
        // 과제 별 시작 시각과 진행 시간을 정수형으로 관리
        int[][] time = new int[n][3]; // [과제 번호, 시작 시각, 진행 시간]
        for (int i = 0; i < n; i++) {
            time[i] = new int[] {i, calSec(plans[i][1]), Integer.parseInt(plans[i][2])};
        }
        
        // 과제를 시간 순으로 정렬
        Arrays.sort(time, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        // 순서대로 과제 진행
        String[] answer = new String[n];
        Stack<int[]> stack = new Stack<>(); // [과제 번호, 남은 시간]
        int finish = 0; // 끝난 과제 개수
        int curTime = 0; // 현재 시간
        for (int i = 0; i < n; i++) {
            int[] cur = time[i];
            
            // 멈춘 과제가 없다면, 현재 시간을 새 과제 시작 시간으로 설정
            if (stack.isEmpty()) {
                stack.push(new int[] {cur[0], cur[2]});
                curTime = cur[1];
                continue;
            }
            
            // 멈춘 과제가 있다면, 새 과제를 시작하기 전에 최대한 진행
            while (!stack.isEmpty()) {
                int[] prev = stack.peek();
                
                // 멈춘 과제가 완료되는 시점이 현재 과제를 시작하는 시점보다 빠르다면 완료 처리
                if (curTime + prev[1] <= cur[1]) {
                    stack.pop();
                    answer[finish++] = plans[prev[0]][0];
                    curTime += prev[1];
                } 
                // 현재 과제를 시작하기 전까지 멈춘 과제를 완료할 수 없다면 할 수 있는 데까지 진행
                else {
                    int t = cur[1] - curTime; // 현재 과제를 시작하기 전까지 남은 시간 계산
                    prev[1] -= t; // 멈춘 과제의 진행 시간 갱신
                    break;
                }
            }
            
            // 현재 시간을 새 과제 시작 시간으로 설정
            curTime = cur[1];
            stack.push(new int[] {cur[0], cur[2]});
        }
        
        while (!stack.isEmpty()) {
            answer[finish++] = plans[stack.pop()[0]][0];
        }
        
        return answer;
    }
    
    static int calSec(String time) {
        String[] t = time.split(":");
        return 60 * Integer.parseInt(t[0]) + Integer.parseInt(t[1]);
    }
}