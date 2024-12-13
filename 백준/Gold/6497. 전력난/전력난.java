import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int m, n, parents[];
    static Edge[] edges;

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int cost;

        public Edge(int x, int y, int z) {
            this.start = x;
            this.end = y;
            this.cost = z;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 집의 수 (vertex)
            n = Integer.parseInt(st.nextToken()); // 길의 수 (edge)

            if(m == 0 && n == 0) {
                break;
            }

            edges = new Edge[n];
            int total = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                edges[i] = new Edge(x, y, z);
                total += z; // 전체 비용 계산
            }

            Arrays.sort(edges); // 비용 기준으로 오름차순 정렬

            parents = new int[m];
            Arrays.fill(parents, -1);

            int cost = 0;
            int cnt = 0;
            for(Edge e : edges) {
                if(union(e.start, e.end)) {
                    cost += e.cost; // 최소 비용 계산
                    if(++cnt == m) break;
                }
            }

            // 절약 비용 = 전체 비용 - 최소 비용
            System.out.println(total - cost);
        }
    }

    static int findRoot(int a) {
        if(parents[a] < 0) return a;
        return parents[a] = findRoot(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = findRoot(a);
        int bRoot = findRoot(b);

        // a와 b의 root가 같다면 이미 같은 집합이라는 의미이므로 false 반환
        if(aRoot == bRoot) return false;

        // a와 b가 같은 집합이 아니라면 합침
        parents[bRoot] = aRoot;
        return true;
    }
}