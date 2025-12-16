import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < K; tc++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V+1];
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }
            visited = new int[V+1];

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            boolean res = true;
            for (int i = 1; i <= V; i++) {
                if (visited[i] == 0) {
                    if (!bfs(i, 1)) {
                        res = false;
                        break;
                    }
                }
            }

            if (res) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }

        System.out.println(sb);
    }

    static boolean bfs(int start, int num) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = num;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt : graph[cur]) {
                if (visited[cur] == visited[nxt]) return false;

                if (visited[nxt] == 0) {
                    visited[nxt] = visited[cur] * (-1);
                    q.offer(nxt);
                }
            }
        }
        return true;
    }
}