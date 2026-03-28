import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int G = Integer.parseInt(st.nextToken()); // 최대공약수
        int L = Integer.parseInt(st.nextToken()); // 최소공배수
        int N = L / G;

        // 1. 약수 쌍 찾기: a x b = N을 만족하는 a, b 찾기
        int sum = Integer.MAX_VALUE;
        int[] res = new int[2];
        for (int a = 1; a <= Math.sqrt(N); a++) {
            if (N % a == 0) {
                int b = N / a;

                // 2. a와 b가 서로소인지 확인
                if (gcd(a, b) == 1) {
                    // 3. 최소값 갱신
                    if (a + b < sum) {
                        sum = a + b;
                        res[0] = a;
                        res[1] = b;
                    }
                }
            }
        }

        System.out.println(res[0] * G + " " + res[1] * G);
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }
}