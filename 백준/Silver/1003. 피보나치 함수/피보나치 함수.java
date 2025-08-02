import java.io.*;

public class Main  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int[][] cnt = new int[41][2];
        cnt[0][0] = 1;
        cnt[0][1] = 0;
        cnt[1][0] = 0;
        cnt[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            cnt[i][0] = cnt[i-1][0] + cnt[i-2][0];
            cnt[i][1] = cnt[i-1][1] + cnt[i-2][1];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(cnt[N][0]).append(" ").append(cnt[N][1]).append('\n');
        }

        System.out.print(sb);
    }
}