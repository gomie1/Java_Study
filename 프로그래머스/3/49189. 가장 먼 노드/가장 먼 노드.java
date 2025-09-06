import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        
        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int[] dist = new int[n+1];
        int max = 0;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int nxt : graph[cur]) {
                if (nxt != 1 && dist[nxt] == 0) {
                    dist[nxt] = dist[cur] + 1;
                    q.offer(nxt);
                    if (max < dist[nxt]) max = dist[nxt];
                }
            }
        }
        
        int answer = 0;
        for (int d : dist) {
            if (d == max) answer++;
        }
        
        return answer;
    }
}