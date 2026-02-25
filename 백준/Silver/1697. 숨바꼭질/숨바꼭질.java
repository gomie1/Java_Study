import java.io.*;
import java.util.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    static int bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {N, 0});
        boolean[] visited = new boolean[100001];
        visited[N] = true;

        int ans = 0;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            if (cur[0] == K) {
                ans = cur[1];
                break;
            }

            if (cur[0] * 2 <= 100000 && !visited[2*cur[0]]) {
                visited[2*cur[0]] = true;
                dq.offer(new int[] {2*cur[0], cur[1]+1});
            }

            if (cur[0] + 1 <= 100000 && !visited[cur[0]+1]) {
                visited[cur[0] + 1] = true;
                dq.offer(new int[] {cur[0]+1, cur[1]+1});
            }

            if (cur[0] - 1 >= 0 && !visited[cur[0]-1]) {
                visited[cur[0] - 1] = true;
                dq.offer(new int[] {cur[0]-1, cur[1]+1});
            }
        }

        return ans;
    }
}