import java.io.*;
import java.util.*;

public class Main {
    static int N, dist[];
    static ArrayList<int[]>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[from].add(new int[] {to, weight});
            tree[to].add(new int[] {from, weight});
        }

        // 1. 임의의 1번 노드에서 가장 먼 노드 찾기 (A)
        dist = new int[N+1];
        bfs(1);
        int maxDist = dist[1];
        int A = 1;
        for (int i = 2; i <= N; i++) {
            if (maxDist < dist[i]) {
                maxDist = dist[i];
                A = i;
            }
        }

        // 2. n1에서 가장 먼 노드 찾기 (B)
        Arrays.fill(dist, 0);
        bfs(A);
        maxDist = dist[1];
        int B = 1;
        for (int i = 2; i <= N; i++) {
            if (maxDist < dist[i]) {
                maxDist = dist[i];
                B = i;
            }
        }

        // 3. A에서 시작하는 거리 중 두 번째로 먼 거리 찾기
        int res1 = 0;
        for (int i = 1; i <= N; i++) {
            if (i == B) continue;
            if (res1 < dist[i]) res1 = dist[i];
        }

        // 4. B에서 시작하는 거리 중 두 번쨰로 먼 거리 찾기
        Arrays.fill(dist, 0);
        bfs(B);
        int res2 = 0;
        for (int i = 1; i <= N; i++) {
            if (i == A) continue;
            if (res2 < dist[i]) res2 = dist[i];
        }

        System.out.println(Math.max(res1, res2));
    }

    static void bfs(int start) {
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        dq.offer(new int[] {start, 0});
        visited[start] = true;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();

            for (int[] nxt : tree[cur[0]]) {
                if (!visited[nxt[0]]) {
                    visited[nxt[0]] = true;
                    dq.offer(new int[] {nxt[0], cur[1]+nxt[1]});
                    dist[nxt[0]] = cur[1] + nxt[1];
                }
            }
        }
    }
}