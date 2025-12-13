import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long[] arr = new long[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Long.parseLong(st.nextToken());
            }

            long sum = 0;
            for (int j = 0; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    sum += gcd(arr[j], arr[k]);
                }
            }

            sb.append(sum).append('\n');
        }

        System.out.println(sb);
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}