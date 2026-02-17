import java.util.*;

class Solution {
    static char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    static HashMap<String, Integer> dictionary;
    static int num;
    
    public int solution(String word) {
        dictionary = new HashMap<>();
        num = 1;
        makeWords(0, "");
        return dictionary.get(word);
    }
    
    static void makeWords(int cnt, String word) {
        if (!word.isEmpty() && !dictionary.containsKey(word)) dictionary.put(word, num++);
        
        if (cnt == 5) return;
        
        for (int i = 0; i < 5; i++) {
            makeWords(cnt+1, word+alpha[i]);
        }
    }
}