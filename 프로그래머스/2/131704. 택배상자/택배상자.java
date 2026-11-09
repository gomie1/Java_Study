import java.util.*;

class Solution {
    public int solution(int[] order) {
        int n = order.length;
        Stack<Integer> stack = new Stack<>();
        
        int cur = 0;
        int box = 1;
        int answer = 0;
        while (box <= n) {
            // 현재 박스를 트럭에 실을 수 있다면 싣기
            if (order[cur] == box) {
                answer++;
                cur++;
            } else { // 현재 박스를 트럭에 실을 수 없다면? 보조 컨베이어 벨트 확인
                // 보관 중인 상자가 있다면 트럭에 실을 수 있을 때까지 싣기
                while (!stack.isEmpty() && stack.peek() == order[cur]) {
                    stack.pop();
                    cur++;
                    answer++;
                }
                
                stack.push(box);
            }
            
            box++;
        }
        
        while (!stack.isEmpty() && stack.peek() == order[cur]) {
            stack.pop();
            answer++;
            cur++;
        }
        
        return answer;
    }
}