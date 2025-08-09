import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] tree = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if (max < tree[i]) max = tree[i];
        }

        int start = 0;
        int end = max;
        int ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            long height = 0;
            for (int h : tree) {
                if (h > mid) height += h - mid;
            }

            if (height >= M) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }

        System.out.println(ans);
    }
}