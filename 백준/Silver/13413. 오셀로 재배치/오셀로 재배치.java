import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            String init = br.readLine();
            String res = br.readLine();

            int cntW = 0;
            int cntB = 0;
            for (int i = 0; i < N; i++) {
                if (init.charAt(i) == 'W' && res.charAt(i) == 'B') cntW++;
                else if (init.charAt(i) == 'B' && res.charAt(i) == 'W') cntB++;
            }

            int ans = 0;
            int min = Math.min(cntW, cntB);
            int max = Math.max(cntW, cntB);
            ans += min;
            ans += max - min;
            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }
}