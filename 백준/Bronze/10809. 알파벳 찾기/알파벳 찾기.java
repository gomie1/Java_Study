import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);

        for (int i = 0; i < S.length(); i++) {
            int idx = (S.charAt(i) - '0') - 49;
            if (alpha[idx] == -1) alpha[idx] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(alpha[i]).append(" ");
        }

        System.out.println(sb);
     }
}