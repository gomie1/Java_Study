import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] increase = new int[N];
        for (int i = 0; i < N; i++) {
            increase[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) increase[i] = Math.max(increase[i], increase[j] + 1);
            }
        }

        int[] decrease = new int[N];
        for (int i = N-1; i >= 0; i--) {
            decrease[i] = 1;
            for (int j = N-1; j > i; j--) {
                if (A[j] < A[i]) decrease[i] = Math.max(decrease[i], decrease[j] + 1);
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, increase[i] + decrease[i] - 1);
        }

        System.out.println(max);
    }
}