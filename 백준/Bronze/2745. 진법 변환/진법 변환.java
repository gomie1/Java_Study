import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        if (N.equals("0")) {
            System.out.println(0);
            return;
        }

        int num = 0;
        int weight = N.length() - 1;
        for (char c : N.toCharArray()) {
            if (c >= 'A' && c <= 'Z') num += ((c - 'A') + 10) * Math.pow(B, weight--);
            else num += (c - '0') * Math.pow(B, weight--);
        }

        System.out.println(num);
    }
}