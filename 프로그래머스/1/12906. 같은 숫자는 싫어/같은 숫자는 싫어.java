import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        int size = arr.length;
        stack.push(arr[0]);
        dq.add(arr[0]);
        for (int i = 1; i < size; i++) {
            if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
                dq.add(arr[i]);
            }
        }
        
        int[] answer = new int[dq.size()];
        size = dq.size();
        for (int i = 0; i < size; i++) {
            answer[i] = dq.poll();
        }
        
        return answer;
    }
}