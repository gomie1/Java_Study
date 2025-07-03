import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] weight = {1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1};
        char[] isbn = br.readLine().toCharArray();

        int sum = 0;
        int star_idx = 0;
        for (int i = 0; i < 13; i++) {
            if (isbn[i] == '*') star_idx = i;
            else sum += (isbn[i] - '0') * weight[i];
        }

        int ans = 0;
        for (int i = 0; i < 10; i++) {
            sum += i * weight[star_idx];
            if (sum % 10 == 0) {
                ans = i;
                break;
            }
            sum -= i * weight[star_idx];
        }

        System.out.println(ans);
    }
}