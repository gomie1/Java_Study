import java.io.*;
import java.util.*;

public class Main {
    static int D(int x) { return (2 * x) % 10000; }
    static int S(int x) { return (x + 9999) % 10000; }
    static int L(int x) { return (x % 1000) * 10 + (x / 1000); }
    static int R(int x) { return (x / 10) + (x % 10) * 1000; }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            ArrayDeque<Integer> dq = new ArrayDeque<>();
            boolean[] visited = new boolean[10000];
            dq.offer(A);
            visited[A] = true;

            int[] parent = new int[10000];
            char[] op = new char[10000];

            while (!dq.isEmpty()) {
                int cur = dq.poll();
                if (cur == B) break;

                int[] nexts = { D(cur), S(cur), L(cur), R(cur) };
                char[] ops = { 'D', 'S', 'L', 'R' };

                for (int i = 0; i < 4; i++) {
                    int nx = nexts[i];
                    if (!visited[nx]) {
                        visited[nx] = true;
                        parent[nx] = cur;
                        op[nx] = ops[i];
                        dq.offer(nx);
                        if (nx == B) break;
                    }
                }
            }

            String str = "";
            for (int cur = B; cur != A; cur = parent[cur]) {
               String tmp = op[cur] + str;
               str = tmp;
            }

            sb.append(str + '\n');
        }
        System.out.println(sb);
    }
}