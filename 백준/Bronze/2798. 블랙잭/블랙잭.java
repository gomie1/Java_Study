import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans;
    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        cards = new int[N];
        ans = 0;
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        combination(0, 0, 0);
        System.out.println(ans);
    }

    static void combination(int start, int sum, int depth) {
        if (sum > M) return;

        if (depth == 3) {
            if (ans < sum) ans = sum;
            return;
        }

        for (int i = start; i < N; i++) {
            combination(i + 1, sum + cards[i], depth + 1);
        }
    }
}