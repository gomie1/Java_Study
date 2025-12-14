import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String binary = br.readLine();

        if (binary.equals("0")) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        int len = binary.length();
        if (binary.length() % 3 != 0) {
            while (len % 3 != 0) {
                sb.append(0);
                len++;
            }
            sb.append(binary);
            binary = sb.toString();
        }

        sb = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 3) {
            int octal = 0;
            int weight = 2;

            for (int j = 0; j < 3; j++) {
                octal += (binary.charAt(i + j) - '0') * Math.pow(2, weight--);
            }
            sb.append(octal);
        }

        System.out.println(sb);
    }
}