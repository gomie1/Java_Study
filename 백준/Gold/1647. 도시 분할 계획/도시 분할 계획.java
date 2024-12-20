import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, parents[];
    static Edge[] edges;

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 집의 개수
        M = Integer.parseInt(st.nextToken()); // 길의 개수

        edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(A, B, C);
        }
        Arrays.sort(edges);

        parents = new int[N+1];
        Arrays.fill(parents, -1);

        int cnt = 0;
        int res = 0;
        for(Edge e : edges) {
            if(union(e.start, e.end)) {
                if(++cnt == N-1) break;
                res += e.cost;
            }
        }

        System.out.println(res);
    }

    private static int findRoot(int a) {
        if(parents[a] < 0) return a;
        return parents[a] = findRoot(parents[a]);
    }

    private static boolean union(int a, int b) {
        int aRoot = findRoot(a);
        int bRoot = findRoot(b);

        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }
}