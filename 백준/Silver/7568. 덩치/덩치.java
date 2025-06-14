import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int k = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) k++;
            }
            sb.append(k+1).append('\n');
        }

        System.out.print(sb);
    }
}