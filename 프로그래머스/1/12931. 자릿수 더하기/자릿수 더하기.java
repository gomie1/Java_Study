import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        while(n > 0) {
            int val = n % 10;
            answer += val;
            n -= val;
            n /= 10;
        }

        return answer;
    }
}