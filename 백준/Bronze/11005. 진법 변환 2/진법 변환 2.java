import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        if (N == 0) {
            System.out.println(0);
            return;
        }

        while (N > 0) {
            int n = N % B;

            if (n < 10) sb.append(n);
            else sb.append((char) ('A' + (n - 10)));

            N /= B;
        }

        System.out.println(sb.reverse().toString());
    }
}