import java.io.*;
import java.util.*;

public class Main {
    static int r = 31, M = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int ans = 0;
        for (int i = 0; i < L; i++) {
            ans += ((str.charAt(i) - '0') - 48) * (Math.pow(r, i));
        }

        System.out.println(ans % M);
    }
}