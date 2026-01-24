import java.io.*;
import java.util.*;

public class Main {
    static int N, X, times[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] go = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            go[i] = new ArrayList<>();
        }

        ArrayList<int[]>[] back = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            back[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            go[to].add(new int[] {from, time});
            back[from].add(new int[] {to, time});
        }

        times = new int[N+1];
        dijkstra(X, go); // 각 마을에서 파티장으로 가는 최단 경로 구하기
        dijkstra(X, back); // 파티장에서 각 마을로 돌아가는 최단 경로 구하기

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, times[i]);
        }
        System.out.println(ans);
    }

    static void dijkstra(int start, ArrayList<int[]>[] roads) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        pq.offer(new int[] {start, 0});

        int[] time = new int[N+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[1] > time[cur[0]]) continue;

            for (int[] nxt : roads[cur[0]]) {
                if (nxt[1] + cur[1] < time[nxt[0]]) {
                    time[nxt[0]] = nxt[1] + cur[1];
                    pq.offer(new int[] {nxt[0], time[nxt[0]]});
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            times[i] += time[i];
        }
    }
}