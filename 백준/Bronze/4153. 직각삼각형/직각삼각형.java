import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int[] num = new int[3];
        while (true) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 3; i++) {
                num[i] = Integer.parseInt(st.nextToken());
                num[i] *= num[i];
            }
            Arrays.sort(num);

            if (num[0] == 0 && num[1] == 0 && num[2] == 0) break;

            if (num[0] + num[1] == num[2]) sb.append("right\n");
            else sb.append("wrong\n");
        }

        System.out.println(sb);
    }
}