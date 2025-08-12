import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String str = br.readLine();
        
        String Pn = "IOI";
        for (int i = 2; i <= N; i++) {
            Pn += "OI";
        }

        int len = Pn.length() - 1;
        int cnt = 0;

        for (int left = 0; left < str.length() - len; left++) {
            String cur = "";
            int right = left + len;
            for (int i = left; i <= right; i++) {
                cur += str.charAt(i);
            }

            if (cur.equals(Pn)) cnt++;
        }

        System.out.println(cnt);
    }
}