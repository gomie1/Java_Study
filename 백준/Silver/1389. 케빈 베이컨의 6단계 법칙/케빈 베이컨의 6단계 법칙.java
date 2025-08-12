import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N+1];
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

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        int tmp = Integer.MAX_VALUE;
        int ans = 0;

        for (int i = 1; i <= N; i++) {
            q.offer(new int[] {i, 0});
            visited[i] = true;
            int sum = 0;

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                sum += cur[1];

                for (int nxt : graph[cur[0]]) {
                    if (!visited[nxt]) {
                        q.offer(new int[] {nxt, cur[1]+1});
                        visited[nxt] = true;
                    }
                }
            }

            if (tmp > sum) {
                tmp = sum;
                ans = i;
            }

            Arrays.fill(visited, false);
        }

        System.out.println(ans);
    }
}