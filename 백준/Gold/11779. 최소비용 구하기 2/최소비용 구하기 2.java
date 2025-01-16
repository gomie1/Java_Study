import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Bus implements Comparable<Bus> {
        int city;
        int cost;
        ArrayList<Integer> path;

        public Bus(int city, int cost, ArrayList<Integer> path) {
            this.city = city;
            this.cost = cost;
            this.path = path;
        }

        @Override
        public int compareTo(Bus o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수

        StringTokenizer st;
        ArrayList<Bus>[] info = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            info[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            info[s].add(new Bus(e, c, new ArrayList<>()));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 1
        int end = Integer.parseInt(st.nextToken()); // 5

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Bus> q = new PriorityQueue<>();
        ArrayList<Integer> sp = new ArrayList<>();
        sp.add(start);
        q.offer(new Bus(start, 0, sp));

        ArrayList<Integer>[] path = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            path[i] = new ArrayList<>();
        }

        while(!q.isEmpty()) {
            Bus cur = q.poll();
            if(dist[cur.city] < cur.cost) continue;

            for (Bus nxt : info[cur.city]) {
                if(dist[cur.city] + nxt.cost < dist[nxt.city]) {
                    dist[nxt.city] = dist[cur.city] + nxt.cost;
                    ArrayList<Integer> p = (ArrayList<Integer>) cur.path.clone();
                    p.add(nxt.city);
                    q.offer(new Bus(nxt.city, dist[nxt.city], p));
                    path[nxt.city] = p;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dist[end]).append("\n");
        sb.append(path[end].size()).append("\n");
        for (int c : path[end]) {
            sb.append(c).append(" ");
        }
        System.out.println(sb);
    }
}