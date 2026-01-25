import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N == 2 || N == 3) {
            System.out.println(1);
            return;
        }

        findPrime();

        int ptr = 2;
        int sum = 2;
        int cnt = 0;
        for (int i = 3; i <= N; i++) {
            if (!isPrime[i]) continue;

            sum += i;
            if (sum == N) cnt++;
            else if (sum > N) {
                for (int j = ptr; j <= i; j++) {
                    if (isPrime[j]) {
                        if (sum <= N) {
                            ptr = j;
                            if (sum == N) cnt++;
                            break;
                        }

                        sum -= j;
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    static void findPrime() {
        isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}