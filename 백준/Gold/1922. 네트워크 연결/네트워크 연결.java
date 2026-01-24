import java.io.*;
import java.util.*;

public class Main {
    static int N, parents[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
           return o1[2] - o2[2];
        });
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.offer(new int[] {a, b, cost});
        }

        parents = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        int cnt = 0;
        int ans = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (union(cur[0], cur[1])) {
                ans += cur[2];
                if (++cnt == N-1) break;
            }
        }

        System.out.println(ans);
    }

    static int findRoot(int x) {
        if (parents[x] == x) return x;
        return parents[x] = findRoot(parents[x]);
    }

    static boolean union(int a, int b) {
        int aRoot = findRoot(a);
        int bRoot = findRoot(b);
        if (aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }
}