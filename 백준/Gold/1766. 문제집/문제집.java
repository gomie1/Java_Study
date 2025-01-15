import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 문제의 수
        int M = Integer.parseInt(st.nextToken()); // 정보의 수

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] prev = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);
            prev[B]++;
        }

        // Dijkstra
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if(prev[i] == 0) pq.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(" ");

            for (int nxt : graph[cur]) {
                prev[nxt]--;
                if(prev[nxt] == 0) pq.offer(nxt);
            }
        }

        System.out.println(sb);
    }
}