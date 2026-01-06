import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        // 카드 묶음 중 항상 가장 작은 묶음 2개를 합쳐야 함
        int ans = 0;
        while (pq.size() >= 2) {
            int a = pq.poll();
            int b = pq.poll();

            ans += a + b;
            pq.offer(a + b);
        }

        System.out.println(ans);
    }
}