import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int M = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수

        ArrayList<Integer>[] network = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            network[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            network[a].add(b);
            network[b].add(a);
        }

        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        int ans = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt : network[cur]) {
                if (!visited[nxt]) {
                    q.offer(nxt);
                    visited[nxt] = true;
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}