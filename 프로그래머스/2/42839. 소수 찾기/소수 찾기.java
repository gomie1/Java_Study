import java.util.*;

class Solution {
    static HashSet<Integer> set;
    static boolean[] visited;
    
    public int solution(String numbers) {
        // 1. dfs(순열)를 통해 만들 수 있는 모든 숫자 생성
        set = new HashSet<Integer>();
        visited = new boolean[numbers.length()];
        dfs(numbers.length(), "", numbers);
        
        // 2. 소수 판별하기
        int answer = 0;
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            if (isPrime(iter.next())) answer++;
        }
        
        return answer;
    }
    
    static void dfs(int n, String number, String origin) {
        if (!number.equals("")) {
            set.add(Integer.parseInt(number));
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(n, number+origin.charAt(i), origin);
                visited[i] = false;
            }
        }
    }
    
    static boolean isPrime(int n) {
        if (n < 2) return false;
        
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}