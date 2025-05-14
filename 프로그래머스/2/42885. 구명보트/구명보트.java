import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int start = 0;
        int end = people.length - 1;
        Arrays.sort(people);
        for(int i = end; i >= 0; i--) {
            if(people[i] > limit) answer++;
            else {
                end = i;
                break;
            }
        }
        
        while (start <= end) {
            if (people[start] + people[end] <= limit) start++;
            answer++;
            end--;
        }
        
        return answer;
    }
}