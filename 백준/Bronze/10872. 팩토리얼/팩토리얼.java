import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(N == 0 ? 1 : factorial(N));
    }

    static int factorial(int n) {
        if (n == 1) return 1;
        else return n * factorial(n - 1);
    }
}