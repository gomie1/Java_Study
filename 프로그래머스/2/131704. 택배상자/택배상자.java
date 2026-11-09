import java.util.*;

class Solution {
    public int solution(int[] order) {
        int n = order.length;
        Stack<Integer> stack = new Stack<>();
        
        int cur = 0;
        int box = 1;
        while (box <= n) {
            // 1. 현재 박스를 트럭에 실을 수 있다면 싣기
            if (order[cur] == box) {
                cur++;
                box++;
            } 
            // 2. 보조 컨베이어 벨트의 맨 앞 박스를 트럭에 실을 수 있다면 싣기
            else if (!stack.isEmpty() && stack.peek() == order[cur]) { 
                stack.pop();
                cur++;
            }
            // 3. 트럭에 박스를 실을 수 없다면 보조 컨베이어 벨트에 보관
            else {
                stack.push(box);
                box++;
            }
        }
        
        // 메인 벨트 상자가 다 끝난 후, 보조 스택에 남은 것들 중 실을 수 있는 것 마저 싣기
        while (!stack.isEmpty() && stack.peek() == order[cur]) {
            stack.pop();
            cur++;
        }
        
        // 총 실은 상자의 개수는 order 배열에서 몇 번째까지 처리했는지(cur)와 같으므로 cur 반환
        return cur;
    }
}