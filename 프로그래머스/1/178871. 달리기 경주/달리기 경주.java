import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int n = players.length;
        
        Map<String, Integer> ranking = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ranking.put(players[i], i);
        }
        
        for (String name : callings) {
            int rank = ranking.get(name);
            String p = players[rank-1];
            
            ranking.put(name, rank-1);
            ranking.put(p, rank);
            
            players[rank] = p;
            players[rank-1] = name;
        }
        
        return players;
    }
}