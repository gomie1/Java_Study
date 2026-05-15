import java.util.*;

class Solution {
    static Map<String, Integer> num;
    static int[][] ticketCnt;
    static List<Integer> path;
    static List<String> airport;
    static int n, ticketNum;
    static String[] answer;
    static boolean isFound = false;
    
    public String[] solution(String[][] tickets) {
        // 주어진 공항을 리스트에 담기 (중복 X)
        airport = new ArrayList<>();
        for (String[] ticket : tickets) {
            if (!airport.contains(ticket[0])) airport.add(ticket[0]);
            if (!airport.contains(ticket[1])) airport.add(ticket[1]);
        }
        
        // 알파벳 순서가 앞서는 경로부터 가기 위해 정렬
        Collections.sort(airport);
        
        // 공항 별 번호 메기기
        num = new HashMap<>();
        n = airport.size();
        for (int i = 0; i < n; i++) {
            num.put(airport.get(i), i);
        }
        
        // 티켓에 표기된 대로 방문 가능 여부 표시
        ticketCnt = new int[n][n];
        for (String[] ticket : tickets) {
            int from = num.get(ticket[0]);
            int to = num.get(ticket[1]);
            
            ticketCnt[from][to]++;
        }
        
        path = new ArrayList<>();
        path.add(num.get("ICN"));
        ticketNum = tickets.length;
        dfs(num.get("ICN"), 0);
        
        return answer;
    }
    
    static void dfs(int cur, int cnt) {
        // 이미 정답을 찾았다면 즉시 종료
        if (isFound) return;
        
        // 티켓을 모두 사용했다면 종료 (정렬했으니까 가장 처음 조건을 만족한 것이 답이 됨)
        if (cnt == ticketNum) {
            answer = new String[path.size()];
            for (int i = 0; i < path.size(); i++) {
                answer[i] = airport.get(path.get(i));
            }
            
            isFound = true;
            return;
        }
        
        for (int nxt = 0; nxt < n; nxt++) {
            if (cur == nxt || ticketCnt[cur][nxt] == 0) continue; // 자기 자신은 Pass
            
            // 현재 공항에서 다음 공항에 방문할 수 있다면 이동
            if (ticketCnt[cur][nxt] > 0) {
                ticketCnt[cur][nxt]--;
                path.add(nxt);
                
                dfs(nxt, cnt+1);
                
                path.remove(path.size()-1);
                ticketCnt[cur][nxt]++;
            }
        }
    }
}