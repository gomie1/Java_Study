import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        permutation("", 0);

        System.out.println(sb);
    }

    static void permutation(String ans, int depth) {
        if (depth == m) {
            sb.append(ans);
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(ans + Integer.toString(i) + " ", depth + 1);
                visited[i] = false;
            }
        }
    }
}