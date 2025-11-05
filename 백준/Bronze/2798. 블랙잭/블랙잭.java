import java.io.*;
import java.util.*;

public class Main {
    static int cards[], ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        ans = 0;
        combination(0, 0, 0, N, M);
        System.out.println(ans);
    }
    
    static void combination(int start, int cnt, int num, int n, int m) {
        // 1. N장의 카드 중 3장 고르기
        if (cnt == 3) {
            // 2. 고른 카드의 합이 숫자 M이 넘지 않는지 확인
            if (m < num) return;

            // 3. M을 넘지 않고, 현재까지의 최대값보다 크다면 최대값 갱신
            if (ans < num) ans = num;
            return;
        }

        for (int i = start; i < n; i++) {
            combination(i+1, cnt+1, num+cards[i], n, m);
        }
    }
}