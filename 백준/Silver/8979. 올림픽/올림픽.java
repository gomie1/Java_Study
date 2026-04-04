import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> score = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) return o2[1] - o1[1];
            if (o1[2] != o2[2]) return o2[2] - o1[2];
            return o2[3] - o1[3];
        });
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            score.add(new int[] {country, gold, silver, bronze});
        }

        int[] cur = score.poll();
        if (cur[0] == K) {
            System.out.println(1);
            return;
        }

        int lank = 1;
        int cnt = 1;
        int[] prev = {cur[1], cur[2], cur[3]};
        while (!score.isEmpty()) {
            cur = score.poll();
            if (prev[0] != cur[1] || prev[1] != cur[2] || prev[2] != cur[3]) {
                lank += cnt;
                cnt = 1;

                prev[0] = cur[1];
                prev[1] = cur[2];
                prev[2] = cur[3];
            } else cnt++;

            if (cur[0] == K) {
                System.out.println(lank);
                break;
            }
        }
    }
}