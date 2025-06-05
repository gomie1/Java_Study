import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (isPrime(Integer.parseInt(st.nextToken()))) ans++;
        }

        System.out.println(ans);
    }

    static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}