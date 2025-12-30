import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Deque<int[]> dq = new ArrayDeque<>();
            Integer[] priority = new Integer[N];
            for (int i = 0; i < N; i++) {
                priority[i] = Integer.parseInt(st.nextToken());
                dq.offer(new int[] {i, priority[i]});
            }

            Arrays.sort(priority, Collections.reverseOrder());
            int idx = 0;
            int cnt = 1;
            while (!dq.isEmpty()) {
                while (dq.peek()[1] != priority[idx]) {
                    dq.offer(dq.poll());
                }

                int[] cur = dq.poll();
                if (cur[0] == M) {
                    sb.append(cnt).append('\n');
                    break;
                }
                idx++;
                cnt++;
            }
        }

        System.out.println(sb);
    }
}