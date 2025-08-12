import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int cnt = 0;
        int ans = 0;

        for (int i = 1; i < M - 1; i++) {
            if (s.charAt(i-1) == 'I' && s.charAt(i) == 'O' && s.charAt(i+1) == 'I') {
                cnt++;
                if (cnt >= N) ans++;
                i++; // 'I'까지 건너뛰기
            } else cnt = 0;
        }

        System.out.println(ans);
    }
}