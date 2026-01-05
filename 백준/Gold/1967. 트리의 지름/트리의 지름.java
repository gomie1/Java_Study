import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<int[]>[] graph;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(0);
            return;
        }

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[parent].add(new int[] {child, weight});
            graph[child].add(new int[] {parent, weight});
        }

        // 1. 루트에서부터 가장 아래에 있는 노드 탐색
        int[] n1 = bfs(1);

        // 2. 가장 아래에 있는 노드에서 가장 멀리 있는 노드 탐색
        int[] n2 = bfs(n1[0]);

        // 3. 트리의 지름 = n1과 n2 사이의 거리;
        System.out.println(n2[1]);
    }

    static int[] bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.add(new int[] {start, 0}); // {node, dist}
        visited[start] = true;

        int[] ans = new int[2];
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (ans[1] < cur[1]) {
                ans[0] = cur[0];
                ans[1] = cur[1];
            }

            for (int[] nxt : graph[cur[0]]) {
                if (!visited[nxt[0]]) {
                    q.add(new int[] {nxt[0], cur[1] + nxt[1]});
                    visited[nxt[0]] = true;
                }
            }
        }

        return ans;
    }
}