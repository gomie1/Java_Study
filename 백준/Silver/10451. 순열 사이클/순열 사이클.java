import java.io.*;
import java.util.*;

public class Main {
    static int N, arr[];
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[N+1];
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    dfs(i);
                    cnt++;
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int cur) {
        if (visited[cur]) return;

        visited[cur] = true;
        dfs(arr[cur]);
    }
}