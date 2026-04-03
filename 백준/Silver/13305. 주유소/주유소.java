import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시의 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] dist = new long[N-1]; // 도로의 길이
        for (int i = 0; i < N-1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long[] price = new long[N]; // 주유소의 리터당 가격
        for (int i = 0; i < N; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        // 도시 별 기름 가격을 내림차순으로 만들기
        // ex. [8, 9, 5, 4, 2, 7, 1] → [8, 8, 5, 4, 2, 2, 1]
        long[] cost = new long[N];
        cost[0] = price[0];
        for (int i = 1; i < N; i++) {
            if (price[i-1] < price[i]) cost[i] = cost[i-1];
            else cost[i] = price[i];
        }

        long total = 0;
        for (int i = 0; i < N-1; i++) {
            total += cost[i] * dist[i];
        }

        System.out.println(total);
    }
}