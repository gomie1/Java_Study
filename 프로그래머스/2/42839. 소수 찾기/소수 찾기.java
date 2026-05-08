import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static boolean[] isSelected;
    
    public int solution(String numbers) {
        isSelected = new boolean[numbers.length()];
        permutation("", numbers);
        
        int answer = 0;
        for (int n : set) {
            if (isPrime(n)) answer++;
        }
        
        return answer;
    }
    
    static void permutation(String cur, String numbers) {
        if (!cur.equals("")) set.add(Integer.parseInt(cur));
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                permutation(cur+numbers.charAt(i), numbers);
                isSelected[i] = false;
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