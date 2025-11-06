import java.util.*;

class Solution {
    static class Word {
        String word;
        int cnt;
        
        public Word(String s, int cnt) {
            this.word = s;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        Queue<Word> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        q.offer(new Word(begin, 0));
        
        int answer = 0;
        while (!q.isEmpty()) {
            Word cur = q.poll();
            if (cur.word.equals(target)) {
                answer = cur.cnt;
                break;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i]) {
                    int count = 0;
                    for (int j = 0; j < cur.word.length(); j++) {
                        if (cur.word.charAt(j) != words[i].charAt(j)) count++;
                    }
                    
                    if (count == 1) {
                        visited[i] = true;
                        q.offer(new Word(words[i], cur.cnt+1));
                    }
                }
            }
        }
        
        return answer;
    }
}