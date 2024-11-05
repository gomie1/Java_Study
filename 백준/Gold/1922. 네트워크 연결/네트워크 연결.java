import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int cost;

        public Edge(int s, int e, int c) {
            this.start = s;
            this.end = e;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    private static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot) return false; // root 노드가 같다면 union 했을 때, 사이클이 발생하므로 union 불가능

        // a, b의 root 노드가 다르다면 b의 root 노드를 a의 root노드로 설정 (Union!!)
        parents[bRoot] = aRoot;
        return true;
    }

    private static int findSet(int a) {
        if(parents[a] < 0) return a; // parents[a]가 초기값인 -1이면 a가 root 노드인 것이므로 본인을 반환
        return parents[a] = findSet(parents[a]); // a가 root 노드가 아니라면 a의 root 노드를 찾아서 a의 부모로 설정
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int M = Integer.parseInt(br.readLine()); // 연결의 수

        // 연결 정보 입력 받기
        StringTokenizer st;
        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 비용이 낮은 순서대로 컴퓨터들의 연결을 정렬
        Arrays.sort(edges);

        // 각 컴퓨터의 부모를 -1로 초기화
        parents = new int[N+1];
        Arrays.fill(parents, -1);

        int res = 0;
        int cnt = 1; // 연결한 컴퓨터의 개수
        for(Edge edge : edges) {
            if(union(edge.start, edge.end)) {
                res += edge.cost;
                if(++cnt == N) break; // 모든 컴퓨터가 다 연결되었다면 종료!
            }
        }

        System.out.println(res);
    }
}