import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Queue<int[]> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                q.offer(new int[] {Integer.parseInt(st.nextToken()), j});
            }

            int ans = 0;
            int cnt = 0;
            while (!q.isEmpty()) {
                int[] cur = q.poll();

                boolean flag = true;
                for (int[] d : q) {
                    if (d[0] > cur[0]) {
                        q.offer(cur);
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    cnt++;
                    if (cur[1] == idx) {
                        ans = cnt;
                        break;
                    }
                }
            }

            sb.append(ans).append('\n');
            q.clear();
        }

        System.out.print(sb);
    }
}