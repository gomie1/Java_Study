import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 부원의 수
        int M = Integer.parseInt(st.nextToken()); // 관계의 수

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[b].add(a);
            indegree[a]++;
        }

        int res = 0;

        /* Topology Sort */
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            res++;

            for (int nxt : graph[cur]) {
                indegree[nxt]--;
                if(indegree[nxt] == 0) q.offer(nxt);
            }
        }

        System.out.println(res);
    }
}