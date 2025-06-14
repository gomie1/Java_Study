class Solution {
    public int[] solution(long n) {
        String s = "" + n;
        int[] answer = new int[s.length()];
        int idx = 0;
        
        while(n > 0) {
            answer[idx] = (int)(n % 10);
            n /= 10;
            idx++;
        }
        
        return answer;
    }
}