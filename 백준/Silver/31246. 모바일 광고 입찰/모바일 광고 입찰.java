import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt = 0; // 낙찰 지면 수
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // MOLOCO가 제시한 입찰 가격
            int B = Integer.parseInt(st.nextToken()); // 입찰가를 제외한 입찰가 중 최고가

            if (A >= B) cnt++;
            else pq.add(B - A);
        }

        int ans = 0;
        while (cnt < K) {
            ans = pq.poll();
            cnt++;
        }

        System.out.println(ans);
    }
}