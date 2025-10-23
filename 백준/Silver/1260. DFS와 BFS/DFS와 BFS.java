import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited1;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        sb = new StringBuilder();
        visited1 = new boolean[N+1];
        visited1[V] = true;
        DFS(V);
        sb.append('\n');
        BFS(N, V);

        System.out.println(sb);
    }

    static void DFS(int cur) {
        sb.append(cur).append(" ");

        for (int nxt : graph[cur]) {
            if (visited1[nxt]) continue;
            visited1[nxt] = true;
            DFS(nxt);
        }
    }

    static void BFS(int N, int V) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited2 = new boolean[N+1];
        q.offer(V);
        visited2[V] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for (int nxt : graph[cur]) {
                if (visited2[nxt]) continue;
                q.offer(nxt);
                visited2[nxt] = true;
            }
        }
    }
}