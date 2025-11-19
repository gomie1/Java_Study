import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 0; test_case < T; test_case++) {
            int n = Integer.parseInt(br.readLine());

            int[][] score = new int[2][n];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    score[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (n == 1) {
                sb.append(Math.max(score[0][0], score[1][0])).append('\n');
                continue;
            }

            int[][] sum = new int[2][n];
            sum[0][0] = score[0][0];
            sum[1][0] = score[1][0];
            sum[0][1] = sum[1][0] + score[0][1];
            sum[1][1] = sum[0][0] + score[1][1];
            int max = Math.max(Math.max(sum[0][0], sum[1][0]), Math.max(sum[0][1], sum[1][1]));

            for (int i = 2; i < n; i++) {
                sum[0][i] = Math.max(sum[1][i-1] + score[0][i], sum[0][i]);
                sum[0][i] = Math.max(sum[0][i-2] + score[0][i], sum[0][i]);
                sum[0][i] = Math.max(sum[1][i-2] + score[0][i], sum[0][i]);
                max = Math.max(max, sum[0][i]);

                sum[1][i] = Math.max(sum[0][i-2] + score[1][i], sum[1][i]);
                sum[1][i] = Math.max(sum[0][i-1] + score[1][i], sum[1][i]);
                sum[1][i] = Math.max(sum[1][i-2] + score[1][i], sum[1][i]);
                max = Math.max(max, sum[1][i]);
            }

            sb.append(max).append('\n');
        }

        System.out.println(sb);
    }
}