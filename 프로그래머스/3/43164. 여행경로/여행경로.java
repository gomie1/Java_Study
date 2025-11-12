import java.util.*;

class Solution {
    static ArrayList<String> answer;
    static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        dfs("ICN", 0, "ICN", tickets, tickets.length);
        Collections.sort(answer);
        
        return answer.get(0).split(" ");
    }
    
    static void dfs(String cur, int cnt, String route, String[][] tickets, int n) {
        if (cnt == n) {
            answer.add(route);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i] && cur.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets[i][1], cnt+1, route + " " + tickets[i][1], tickets, n);
                visited[i] = false;
            }
        }
    }
}