import java.io.*;
import java.util.*;

public class Main {
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (K <= N) {
            System.out.println(N - K);
            return;
        }

        find(N, K, 0);
        System.out.println(ans);
    }

    static void find(int X, int k, int time) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {X, time});
        boolean[] visited = new boolean[100001];
        visited[X] = true;

        while (true) {
            int[] cur = q.poll();
            if (cur[0] == k) {
                ans = cur[1];
                break;
            }

            int[] move = {cur[0] + 1, cur[0] - 1, cur[0] * 2};
            for (int next : move) {
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    q.offer(new int[] {next, cur[1] + 1});
                }
            }
        }
    }
}