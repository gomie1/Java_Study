import java.util.*;

class Node implements Comparable<Node> {
    int start;
    int end;
    int dist;
    
    Node(int start, int end, int dist) {
        this.start = start;
        this.end = end;
        this.dist = dist;
    }
    
    @Override
    public int compareTo(Node n) {
        return this.dist > n.dist ? 1 : -1;
    }
}

class Solution {
    public int solution(int n, int[][] costs) {
        ArrayList<Node>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < costs.length; i++) {
            graph[costs[i][0]].add(new Node(costs[i][0], costs[i][1], costs[i][2]));
            graph[costs[i][1]].add(new Node(costs[i][1], costs[i][0], costs[i][2]));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(Node data : graph[0]) {
            pq.offer(data);
        }
        
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int cnt = 1;
        
        int answer = 0;
        while (!pq.isEmpty() && cnt < n) {
            Node node = pq.poll();
            if(visited[node.end]) continue;
            
            answer += node.dist;
            visited[node.end] = true;
            cnt++;
            
            for(Node next : graph[node.end]) {
                if(visited[next.end]) continue;
                pq.offer(next);
            }
        }
        
        return answer;
    }
}