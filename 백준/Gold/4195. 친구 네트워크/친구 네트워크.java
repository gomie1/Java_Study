import java.io.*;
import java.util.*;

public class Main {
    static int parents[], count[];
    static HashMap<String, Integer> friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            int F = Integer.parseInt(br.readLine());

            parents = new int[F*2];
            count = new int[F*2];
            for (int i = 0; i < F*2; i++) {
                parents[i] = i;
                count[i] = 1;
            }

            friends = new HashMap<>();
            int num = 0;
            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!friends.containsKey(a)) friends.put(a, num++);
                if (!friends.containsKey(b)) friends.put(b, num++);

                sb.append(union(friends.get(a), friends.get(b))).append('\n');
            }
        }

        System.out.println(sb);
    }

    static int findRoot(int a) {
        if (parents[a] == a) return a;
        return parents[a] = findRoot(parents[a]);
    }

    static int union(int x, int y) {
        int xRoot = findRoot(x);
        int yRoot = findRoot(y);

        if (xRoot != yRoot) {
            parents[yRoot] = xRoot;
            count[xRoot] += count[yRoot];
        }

        return count[xRoot];
    }
}