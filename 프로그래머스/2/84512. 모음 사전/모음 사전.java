import java.util.*;

class Solution {
    static List<String> dictionary;
    static char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        // 사전 만들기
        dictionary = new ArrayList<>();
        makeDictionary(0, "");
        Collections.sort(dictionary);
        
        return dictionary.indexOf(word) + 1;
    }
    
    static void makeDictionary(int cnt, String word) {
        if (cnt > 0) dictionary.add(word);
        if (cnt == 5) return;
        
        for (int i = 0; i < 5; i++) {
            makeDictionary(cnt+1, word+alphabet[i]);
        }
    }
}