import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int n = N; n > 0; n--) {
            int half = 1 << (n-1); // 2^(n-1)
            int num = 0;

            if (r >= half) {
                num += 2;
                r -= half;
            }

            if (c >= half) {
                num += 1;
                c -= half;
            }

            ans += num * half * half;
        }

        System.out.println(ans);
    }
}