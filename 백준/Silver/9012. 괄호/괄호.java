import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            int cnt = 0;
            boolean flag = true;

            for (char c : input.toCharArray()) {
                if (c == '(') cnt++;
                else {
                    if (cnt > 0) cnt--;
                    else {
                        sb.append("NO").append('\n');
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                if (cnt == 0) sb.append("YES").append('\n');
                else sb.append("NO").append('\n');
            }
        }

        System.out.println(sb);
    }
}