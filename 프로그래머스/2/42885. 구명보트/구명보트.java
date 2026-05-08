import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        
        int left = 0;
        int right = n-1;
        int answer = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else right--;
            
            answer++;
        }
        
        return answer;
    }
}