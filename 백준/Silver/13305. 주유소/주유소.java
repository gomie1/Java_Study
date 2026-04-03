import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시의 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dist = new int[N-1]; // 도로의 길이
        for (int i = 0; i < N-1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] price = new int[N]; // 주유소의 리터당 가격
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int[] cost = new int[N];
        cost[0] = price[0];
        for (int i = 1; i < N; i++) {
            if (price[i-1] < price[i]) cost[i] = cost[i-1];
            else cost[i] = price[i];
        }

        long total = 0;
        for (int i = 0; i < N-1; i++) {
            total += (long) cost[i] * dist[i];
        }

        System.out.println(total);
    }
}