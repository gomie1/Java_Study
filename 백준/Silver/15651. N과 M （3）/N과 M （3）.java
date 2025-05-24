import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dup_perm("", 0);
        System.out.println(sb);
    }

    static void dup_perm(String ans, int depth) {
        if (depth == m) {
            sb.append(ans).append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            dup_perm(ans + Integer.toString(i) + " ", depth + 1);
        }
    }
}