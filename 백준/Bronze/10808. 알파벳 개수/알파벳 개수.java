import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int[] alpha = new int[26];
        for (char c : S.toCharArray()) {
            int idx = (c - '0') - 49;
            alpha[idx]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(alpha[i]).append(" ");
        }

        System.out.println(sb);
     }
}