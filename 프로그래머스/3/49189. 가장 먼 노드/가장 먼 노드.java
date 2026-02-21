import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static int[] dist;
    
    public int solution(int n, int[][] edge) {
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        int maxDist = dijkstra();
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (dist[i] == maxDist) answer++;
        }
        
        return answer;
    }
    
    static int dijkstra() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {1, 0}); // {node, dist}
        
        int maxDist = 0;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            if (maxDist < cur[1]) maxDist = cur[1];
            
            for (int nxt : graph[cur[0]]) {
                if (cur[1] + 1 < dist[nxt]) {
                    dist[nxt] = cur[1] + 1;
                    dq.add(new int[] {nxt, dist[nxt]});
                }
            }
        }
        
        return maxDist;
    }
}