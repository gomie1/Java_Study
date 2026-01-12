import java.io.*;
import java.util.*;

public class Main {
    static int N, degree[];
    static ArrayList<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        degree = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            degree[b]++;
        }

        lineup();
        System.out.println(sb);
    }

    static void lineup() {
        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                visited[i] = true;
                dq.offer(i);
            }
        }

        while (!dq.isEmpty()) {
            int cur = dq.poll();
            sb.append(cur).append(" ");

            for (int nxt : graph[cur]) {
                if (!visited[nxt] && --degree[nxt] == 0) {
                    visited[nxt] = true;
                    dq.offer(nxt);
                }
            }
        }
    }
}