class Solution {
    int answer = 0;
    int ans = 0;
    
    public int solution(String word) {
        permutation("", word, 0);
        return answer;
    }
    
    private void permutation(String str, String word, int cnt) {
        if(str.equals(word)) {
            answer = ans;
            return;
        }
        
        if(cnt == 5) return;
        
        for(String s : new String[] {"A", "E", "I", "O", "U"}) {
            ans++;
            permutation(str+s, word, cnt+1);
        }
    }
}