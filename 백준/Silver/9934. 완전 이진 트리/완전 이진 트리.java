import java.io.*;
import java.util.*;

public class Main {
    static int K, n, nodes[], levels[];
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[K];
        for (int i = 0; i < K; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = (int) Math.pow(2, K);
        nodes = new int[n];
        for (int i = 1; i < n; i++) {
            nodes[i] = Integer.parseInt(st.nextToken());
        }

        int rootIdx = n / 2;
        dfs(rootIdx, 0, rootIdx/2);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            for (int num : graph[i]) {
                sb.append(num).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int idx, int level, int k) {
        if (idx <= 0 || idx >= n || level >= K) return;
        graph[level].add(nodes[idx]);

        dfs(idx - k, level+1, k/2);
        dfs(idx + k, level+1, k/2);
    }
}