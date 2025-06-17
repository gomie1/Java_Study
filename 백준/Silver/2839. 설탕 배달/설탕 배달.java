import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N % 5 == 0) {
            System.out.println(N/5);
            return;
        }

        int cnt = 0;
        while (N > 0) {
            if (N % 5 != 0) {
                N -= 3;
                if (N == 1 || N == 2) {
                    cnt = -1;
                    break;
                }
                cnt++;
            }
            else {
                cnt += N / 5;
                break;
            }
        }

        System.out.println(cnt);
    }
}