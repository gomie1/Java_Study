import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
           if (o1[0] != o2[0]) return o1[0] - o2[0];
           return o2[1] - o1[1];
        });
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int x = -1000000000;
        int y = -1000000000;
        int ans = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] <= y && cur[1] > y) y = cur[1];
            else if (cur[0] > y) {
                ans += y - x;
                x = cur[0];
                y = cur[1];
            }
        }

        System.out.println(ans + (y-x));
    }
}