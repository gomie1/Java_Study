import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[][] fibonacci = new int[41][2]; // [zero, one]
        fibonacci[0][0] = 1; // n이 0인 경우
        fibonacci[1][1] = 1; // n이 1인 경우

        for (int i = 2; i <= 40; i++) {
            fibonacci[i][0] = fibonacci[i-1][0] + fibonacci[i-2][0];
            fibonacci[i][1] = fibonacci[i-1][1] + fibonacci[i-2][1];
        }

        StringBuilder sb = new StringBuilder();
        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(fibonacci[N][0]).append(" ").append(fibonacci[N][1]).append('\n');
        }

        System.out.println(sb);
    }
}