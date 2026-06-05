import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        // 1. 만들 수 있는 모든 수를 set에 저장 (중복 제거)
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        // 2. 만들어진 모든 수를 배열에 담기
        int[] answer = new int[set.size()];
        int idx = 0;
        for (int num : set) answer[idx++] = num;
        
        // 3. 오름차순 정렬
        Arrays.sort(answer);
        
        return answer;
    }
}