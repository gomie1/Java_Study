import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ans = 0;
        int start = N - Integer.toString(N).length() * 9;
        for (int i = start; i < N; i++) {
            int sum = i;

            String str = Integer.toString(i);
            for (char c : str.toCharArray()) {
                sum += c - '0';
            }

            if (sum == N) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }
}