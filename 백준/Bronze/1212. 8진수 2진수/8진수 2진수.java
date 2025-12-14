import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String octal = br.readLine();

        if (octal.equals("0")) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < octal.length(); i++) {
            int n = octal.charAt(i) - '0';
            for (int j = 0; j < 3; j++) {
                if (n == 0) tmp.append(0);
                else tmp.append(n % 2);
                n /= 2;
            }
            
            if (i == 0) sb.append(Integer.parseInt(tmp.reverse().toString()));
            else sb.append(tmp.reverse());
            tmp = new StringBuilder();
        }

        System.out.println(sb);
    }
}