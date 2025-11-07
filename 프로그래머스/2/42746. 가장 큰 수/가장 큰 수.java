import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 1. 각 숫자를 사전순으로 정렬
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            String str1 = a + b;
            String str2 = b + a;
            
            return str2.compareTo(str1);
        });
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            pq.offer(Integer.toString(numbers[i]));
            sum += numbers[i];
        }
        
        // 2. 숫자 이어붙이기
        String answer = "";
        if (sum == 0) answer = "0";
        else {
            while (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        
        return answer;
    }
}