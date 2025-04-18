import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) System.out.println(1);
        else {
            int res = 1;
            int num = 2;
            int cnt = 1;
            int val = 6;
            while (num != N) {
                if (cnt == val) {
                    res++;
                    cnt = 0;
                    val = 6 * res;
                }
                num++;
                cnt++;
            }

            System.out.println(res+1);
        }
    }
}