import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String num = Integer.toString(n, k);
        String[] prime = num.split("0");
        
        int answer = 0;
        for (int i = 0; i < prime.length; i++) {
            if (!prime[i].equals("") && isPrime(Long.parseLong(prime[i]))) answer++;
        }
        
        return answer;
    }
    
    static boolean isPrime(long num) {
        if (num == 1) return false;
        
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}