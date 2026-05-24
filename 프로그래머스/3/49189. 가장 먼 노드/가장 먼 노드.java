import java.util.*;

class Solution {
    static int[] dist;
    static List<Integer>[] graph;
    
    public int solution(int n, int[][] edge) {
        // 그래프 생성
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for(int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        // 1번 노드를 시작으로 각 노드까지의 최단거리 구하기
        dist = new int[n+1];
        int max = bfs(n, edge);
        
        int answer = 0;
        for (int d : dist) {
            if (d == max) answer++;
        }
        
        return answer;
    }
    
    static int bfs(int n, int[][] edge) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {1, 0}); // [노드 번호, 거리]
        
        int max = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            max = Math.max(max, cur[1]);
            
            // 이동 가능한 노드들 중 아직 방문하지 않은 노드만 큐에 담기
            // 1번 노드는 시작점이기 때문에 제외
            for (int nxt : graph[cur[0]]) {
                if (dist[nxt] > 0 || nxt == 1) continue;
                
                q.add(new int[] {nxt, cur[1] + 1});
                dist[nxt] = cur[1] + 1;
            }
        }
        
        return max;
    }
}