import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        for (int i = 0; i < n-1; i++) {
            // 1. i번째 연결 전선을 끊은 그래프 생성
            makeGraph(n, i, wires);
            
            // 2. 그룹별 노드 수 차이의 최소값 구하기
            answer = Math.min(answer, diffGroup(n));
        }
        
        return answer;
    }
    
    static void makeGraph(int n, int idx, int[][] wires) {
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n-1; i++) {
            if (i == idx) continue;
            
            int from = wires[i][0];
            int to = wires[i][1];
            graph[from].add(to);
            graph[to].add(from);
        }
    }
    
    static int diffGroup(int n) {
        visited = new boolean[n+1];
        int[] cnt = new int[2];
        int idx = 0;
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cnt[idx++] = bfs(i);
            }
        }
        
        return Math.abs(cnt[0] - cnt[1]);
    }
    
    static int bfs(int start) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(start);
        int cnt = 1;
        
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            
            for (int nxt : graph[cur]) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    dq.add(nxt);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}