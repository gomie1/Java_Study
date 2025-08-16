import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            else return a[0] - b[0];
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (pq.isEmpty()) sb.append("0\n");
                else sb.append(pq.poll()[0]).append('\n');
            }
            else pq.offer(new int[] {x, Math.abs(x)});
        }

        System.out.print(sb);
    }
}