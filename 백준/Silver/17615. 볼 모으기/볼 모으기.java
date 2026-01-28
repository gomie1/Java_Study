import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] balls = br.readLine().toCharArray();

        int ans = Integer.MAX_VALUE;
        // 1. R을 왼쪽으로 다 몰기
        int start = 0;
        if (balls[0] == 'R') {
            for (int i = 0; i < N; i++) {
                if (balls[i] == 'B') {
                    start = i;
                    break;
                }
            }
        }

        int cnt = 0;
        for (int i = start; i < N; i++) {
            if (balls[i] == 'R') cnt++;
        }
        ans = Math.min(ans, cnt);

        // 2. R을 오른쪽으로 다 몰기
        start = N-1;
        if (balls[N-1] == 'R') {
            for (int i = N-2; i >= 0; i--) {
                if (balls[i] == 'B') {
                    start = i;
                    break;
                }
            }
        }

        cnt = 0;
        for (int i = start; i >= 0; i--) {
            if (balls[i] == 'R') cnt++;
        }
        ans = Math.min(ans, cnt);

        // 3. B를 왼쪽으로 다 몰기
        start = 0;
        if (balls[0] == 'B') {
            for (int i = 0; i < N; i++) {
                if (balls[i] == 'R') {
                    start = i;
                    break;
                }
            }
        }

        cnt = 0;
        for (int i = start; i < N; i++) {
            if (balls[i] == 'B') cnt++;
        }
        ans = Math.min(ans, cnt);

        // 4. B를 오른쪽으로 다 몰기
        start = N-1;
        if (balls[N-1] == 'B') {
            for (int i = N-2; i >= 0; i--) {
                if (balls[i] == 'R') {
                    start = i;
                    break;
                }
            }
        }

        cnt = 0;
        for (int i = start; i >= 0; i--) {
            if (balls[i] == 'B') cnt++;
        }
        ans = Math.min(ans, cnt);

        System.out.println(ans);
    }
}