import java.io.*;
import java.util.*;

public class Main {
    static int N, K, A[], B[];

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N]; // MOLOCO가 제시한 입찰 가격
        B = new int[N]; // 입찰가를 제외한 입찰가 중 최고가
        int cnt = 0; // 낙찰 지면 수
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());

            if (A[i] >= B[i]) cnt++;
            else pq.add(B[i] - A[i]);
        }

        int ans = 0;
        while (cnt < K && !pq.isEmpty()) {
            ans = pq.poll();
            cnt++;
        }

        System.out.println(ans);
    }
}