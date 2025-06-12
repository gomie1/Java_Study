import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int max = Math.max(a, b);
        int min = Math.min(a, b);

        int val = gcd(max, min);

        StringBuilder sb = new StringBuilder();
        sb.append(val).append('\n');
        sb.append(a * b / val);
        System.out.println(sb);
    }

    static int gcd(int max, int min) {
        int val = max % min;
        while (val != 0) {
            int tmp = val;
            val = min % val;
            min = tmp;
        }

        return min;
    }
}