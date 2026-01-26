import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][3];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }


        int[] maxDp = new int[3];
        int[] minDp = new int[3];
        for (int i = 0; i < 3; i++) {
            maxDp[i] = map[0][i];
            minDp[i] = map[0][i];
        }

        for (int i = 1; i < N; i++) {
            int[] maxPrev = { maxDp[0], maxDp[1], maxDp[2] };
            int[] minPrev = { minDp[0], minDp[1], minDp[2] };

            maxDp[0] = Math.max(maxPrev[0], maxPrev[1]) + map[i][0];
            minDp[0] = Math.min(minPrev[0], minPrev[1]) + map[i][0];

            maxDp[1] = Math.max(Math.max(maxPrev[0], maxPrev[1]), maxPrev[2]) + map[i][1];
            minDp[1] = Math.min(Math.min(minPrev[0], minPrev[1]), minPrev[2]) + map[i][1];

            maxDp[2] = Math.max(maxPrev[1], maxPrev[2]) + map[i][2];
            minDp[2] = Math.min(minPrev[1], minPrev[2]) + map[i][2];
        }

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, maxDp[i]);
            min = Math.min(min, minDp[i]);
        }

        System.out.println(max + " " + min);
    }
}