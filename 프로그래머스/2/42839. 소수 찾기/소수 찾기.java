import java.util.*;

class Solution {
    static boolean[] selected;
    static Set<Integer> numSet;
    
    public int solution(String numbers) {
        selected = new boolean[numbers.length()];
        numSet = new HashSet<>();
        permutation("", 0, numbers);
        
        int answer = 0;
        for (int n : numSet) {
            if (isPrime(n)) answer++;
        }
        return answer;
    }
    
    static void permutation(String num, int cnt, String numbers) {
        if (numbers.length() < cnt) return;
        
        if (!num.isEmpty() && cnt <= numbers.length()) numSet.add(Integer.parseInt(num));
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!selected[i]) {
                selected[i] = true;
                permutation(num+numbers.charAt(i), cnt+1, numbers);
                selected[i] = false;
            }
        }
    }
    
    static boolean isPrime(int num) {
        if (num < 2) return false;
        
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}