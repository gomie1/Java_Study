import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] S = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp_up = new int[N];
        for (int i = 0; i < N; i++) {
            dp_up[i] = 1;
            for (int j = 0; j < i; j++) {
                if (S[j] < S[i]) dp_up[i] = Math.max(dp_up[i], dp_up[j]+1);
            }
        }

        int[] dp_down = new int[N];
        for (int i = N-1; i >= 0; i--) {
            dp_down[i] = 1;
            for (int j = N-1; j > i; j--) {
                if (S[j] < S[i]) dp_down[i] = Math.max(dp_down[i], dp_down[j]+1);
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp_up[i] + dp_down[i] - 1);
        }
        System.out.println(max);
    }
}