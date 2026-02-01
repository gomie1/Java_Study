import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 동생이 수빈이보다 뒤에 있다면 걸어서 뒤로가는 방법 밖에 없음
        if (K <= N) {
            System.out.println(N - K);
            return;
        }

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {N, 0});

        boolean[] visited = new boolean[100001];
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();

            if (visited[cur[0]]) continue;
            visited[cur[0]] = true;

            if (cur[0] == K) {
                System.out.println(cur[1]);
                break;
            }

            if (cur[0]*2 <= 100000 && !visited[cur[0]*2]) dq.addFirst(new int[] {cur[0]*2, cur[1]});
            if (cur[0]+1 <= 100000 && !visited[cur[0]+1]) dq.addLast(new int[] {cur[0]+1, cur[1]+1});
            if (cur[0]-1 >= 0 && !visited[cur[0]-1]) dq.addLast(new int[] {cur[0]-1, cur[1]+1});
        }
    }
}