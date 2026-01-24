import java.io.*;
import java.util.*;

public class Main {
    static int parents[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (num == 0) union(a, b);
            else {
                if (findRoot(a) == findRoot(b)) sb.append("YES").append('\n');
                else sb.append("NO").append('\n');
            }
        }

        System.out.println(sb);
    }

    static int findRoot(int x) {
        if (parents[x] == x) return x;
        return parents[x] = findRoot(parents[x]);
    }

    static void union(int a, int b) {
        int aRoot = findRoot(a);
        int bRoot = findRoot(b);
        if (aRoot == bRoot) return;
        parents[bRoot] = aRoot;
    }
}