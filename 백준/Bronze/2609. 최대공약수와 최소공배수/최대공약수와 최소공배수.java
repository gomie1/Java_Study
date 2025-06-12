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

        int val = max % min;
        while (val != 0) {
            int tmp = val;
            val = min % val;
            min = tmp;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min).append('\n');
        sb.append(a * b / min);
        System.out.println(sb);
    }
}