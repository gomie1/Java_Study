import java.util.*;

class Solution {
    static List<int[]>[] graph;
    static int[] dist;
    
    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (int[] r : road) {
            graph[r[0]].add(new int[] {r[1], r[2]});
            graph[r[1]].add(new int[] {r[0], r[2]});
        }
        
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        bfs(N);
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }
        
        return answer;
    }
    
    static void bfs(int n) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {1, 0});
        dist[1] = 0;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int[] nxt : graph[cur[0]]) {
                if (dist[cur[0]] + nxt[1] < dist[nxt[0]]) {
                    dist[nxt[0]] = dist[cur[0]] + nxt[1];
                    q.add(new int[] {nxt[0], dist[nxt[0]]});
                }
            }
        }
    }
}