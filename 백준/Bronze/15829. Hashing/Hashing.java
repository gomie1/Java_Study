import java.io.*;

public class Main {
    static int r = 31;
    static int M = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long hash = 0;
        long pow = 1;

        for (int i = 0; i < L; i++) {
            int a = str.charAt(i) - 'a' + 1;
            hash = (hash + a * pow) % M;
            pow = (pow * r) % M;
        }

        System.out.println(hash);
    }
}