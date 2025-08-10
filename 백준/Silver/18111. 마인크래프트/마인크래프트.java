import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] cnt = new int[257];
        int min = 256;
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int h = Integer.parseInt(st.nextToken());
                cnt[h]++;

                if (h < min) min = h;
                else if (h > max) max = h;
            }
        }

        long ans_s = Long.MAX_VALUE;
        int ans_h = 0;
        for (int h = min; h <= max; h++) {
            int second = 0;
            int block = B;

            for (int x = 0; x <= 256; x++) {
                if (cnt[x] == 0 || x == h) continue;

                int val = Math.abs(h - x) * cnt[x];
                if (x > h) {
                    second += 2 * val;
                    block += val;
                }
                else if (x < h) {
                    second += val;
                    block -= val;
                }
            }

            if (block < 0) continue;

            if (ans_s >= second && ans_h <= h) {
                ans_s = second;
                ans_h = h;
            }
        }

        System.out.println(ans_s + " " + ans_h);
    }
}