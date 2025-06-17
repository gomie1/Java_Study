import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N % 5 == 0) {
            System.out.println(N/5);
            return;
        }

        for (int i = N/5; i >= 0; i--) {
            int val = N - (i * 5);
            if (val % 3 == 0) {
                System.out.println((val / 3) + i);
                return;
            }
        }

        System.out.println(-1);
    }
}