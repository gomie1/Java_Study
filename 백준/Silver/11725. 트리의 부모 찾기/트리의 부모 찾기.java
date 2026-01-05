import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] tree = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            tree[n1].add(n2);
            tree[n2].add(n1);
        }

        int[] parents = new int[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        parents[1] = -1;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt : tree[cur]) {
                if (parents[nxt] == 0) {
                    parents[nxt] = cur;
                    q.add(nxt);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append('\n');
        }
        System.out.println(sb);
    }
}