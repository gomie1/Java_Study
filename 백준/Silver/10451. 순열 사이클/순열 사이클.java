import java.io.*;
import java.util.*;

public class Main {
    static int N, arr[];
    static boolean[] visited, checked;
    static String cycle;

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

            checked = new boolean[N+1];
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (!checked[i]) {
                    if (bfs(i)) {
                        for (int j = 1; j <= N; j++) {
                            if (visited[j]) checked[j] = true;
                        }
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }

    static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        visited = new boolean[N+1];
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            int nxt = arr[cur];
            if (nxt == start) return true;

            if (!visited[nxt]) {
                visited[nxt] = true;
                q.offer(nxt);
            }
        }

        return false;
    }
}