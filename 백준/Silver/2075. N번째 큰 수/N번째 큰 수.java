import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (!pq.isEmpty()) ans = pq.poll();
        }
        System.out.println(ans);
    }
}