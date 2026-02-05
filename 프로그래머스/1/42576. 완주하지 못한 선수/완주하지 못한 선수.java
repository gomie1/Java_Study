import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> players = new HashMap<>();
        for (String s : completion) {
            players.put(s, players.getOrDefault(s, 0) + 1);
        }
        
        for (String s : participant) {
            if (!players.containsKey(s) || players.get(s) == 0) return s;
            players.put(s, players.get(s) - 1);
        }
        
        return "";
    }
}