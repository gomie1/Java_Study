import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        int[] height = new int[N];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
            if (max < height[i]) max = height[i];
        }

        int low = 0; // 절단기의 최소 높이
        int high = max; // 절단기의 최대 높이
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2; // 절단기 높이

            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (height[i] < mid) continue;
                sum += height[i] - mid;
            }

            if (sum < M) high = mid - 1;
            else {
                ans = mid;
                low = mid + 1;
            }
        }

        System.out.println(ans);
    }
}