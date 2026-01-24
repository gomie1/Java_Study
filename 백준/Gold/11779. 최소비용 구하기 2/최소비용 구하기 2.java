import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        ArrayList<int[]>[] bus = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            bus[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            bus[to].add(new int[] {from, cost});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        pq.offer(new int[] {start, 0});

        int[] costs = new int[n+1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[start] = 0;

        int[] parent = new int[n+1];
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[1] > costs[cur[0]]) continue;

            for (int[] nxt : bus[cur[0]]) {
                if (nxt[1] + cur[1] < costs[nxt[0]]) {
                    costs[nxt[0]] = nxt[1] + cur[1];
                    parent[nxt[0]] = cur[0];
                    pq.offer(new int[] {nxt[0], costs[nxt[0]]});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(costs[end]).append('\n');

        ArrayList<Integer> path = new ArrayList<>();
        int cur = end;
        while (cur != 0) {
            path.add(cur);
            cur = parent[cur];
        }

        sb.append(path.size()).append('\n');
        for (int i = path.size() - 1; i >= 0; i--) {
            sb.append(path.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}