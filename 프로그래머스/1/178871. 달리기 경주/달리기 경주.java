import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int n = players.length;
        
        Map<String, Integer> ranking = new HashMap<>();
        Map<Integer, String> number = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ranking.put(players[i], i+1);
            number.put(i+1, players[i]);
        }
        
        for (String name : callings) {
            int rank = ranking.get(name);
            String p = number.get(rank-1);
            
            ranking.put(name, rank-1);
            ranking.put(p, rank);
            
            number.put(rank, p);
            number.put(rank-1, name);
        }
        
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = number.get(i+1);
        }
        
        return answer;
    }
}