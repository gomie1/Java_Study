import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long sx = Long.parseLong(st.nextToken());
        long sy = Long.parseLong(st.nextToken());
        long ex = Long.parseLong(st.nextToken());
        long ey = Long.parseLong(st.nextToken());

        int ans = 0;
        long min = Long.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int M = Integer.parseInt(br.readLine());
            long cx = sx;
            long cy = sy;
            long sum = 0;
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                sum += Math.abs(cx - x) + Math.abs(cy - y);
                cx = x;
                cy = y;
            }

            sum += Math.abs(cx - ex) + Math.abs(cy - ey);
            if (sum < min) {
                min = sum;
                ans = i;
            }
        }

        System.out.println(ans);
    }
}