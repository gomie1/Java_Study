import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int num = 666;
        int cnt = 0;
        while (cnt < N) {
            if (String.valueOf(num).contains("666")) {
                cnt++;
                if (cnt == N) {
                    System.out.println(num);
                    break;
                }
            }
            num++;
        }
    }
}