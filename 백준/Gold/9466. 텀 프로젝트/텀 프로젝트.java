import java.io.*;
import java.util.*;

public class Main {
    static int students[], cnt;
    static boolean visited[], finished[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            students = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];
            cnt = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) dfs(i);
            }
            
            sb.append(n - cnt).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int cur) {
        visited[cur] = true;
        int nxt = students[cur];

        if (!visited[nxt]) dfs(nxt);
        else {
            if (!finished[nxt]) {
                cnt++;
                for (int i = nxt; i != cur; i = students[i]) {
                    cnt++;
                }
            }
        }

        finished[cur] = true;
    }
}