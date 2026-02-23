import java.io.*;
import java.util.*;

public class Main {
    static int N, dist[][];
    static ArrayList<Integer>[] relations;
    static List<List<Integer>> group;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        dist = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], 101);
            dist[i][i] = 0;
        }

        relations = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            relations[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relations[a].add(b);
            relations[b].add(a);
            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        // 1. 그룹 나누기 (bfs)
        visited = new boolean[N+1];
        group = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) group.add(bfs(i));
        }

        // 2. Floyd-Warshall (모든 쌍의 최단 거리 구하기)
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // 3. 위원장 선출
        List<Integer> leaders = new ArrayList<>();
        for (List<Integer> committee : group) {
            int leader = -1;
            int minMaxDist = Integer.MAX_VALUE;

            for (int cur : committee) {
                int maxDist = 0;
                for (int other : committee) {
                    maxDist = Math.max(maxDist, dist[cur][other]);
                }

                if (maxDist < minMaxDist) {
                    minMaxDist = maxDist;
                    leader = cur;
                }
            }

            leaders.add(leader);
        }

        // 4. 위원회 대표 번호 오름차순 정렬
        Collections.sort(leaders);

        StringBuilder sb = new StringBuilder();
        sb.append(group.size()).append('\n');
        for (int leader : leaders) {
            sb.append(leader).append('\n');
        }

        System.out.println(sb);
    }

    static List<Integer> bfs(int start) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(start);
        visited[start] = true;

        ArrayList<Integer> res = new ArrayList<>();
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            res.add(cur);

            for (int nxt : relations[cur]) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    dq.add(nxt);
                }
            }
        }

        return res;
    }
}