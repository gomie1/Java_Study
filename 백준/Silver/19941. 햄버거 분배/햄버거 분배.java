import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String location = br.readLine();
        int ans = 0;
        boolean[] isAte = new boolean[N];
        for (int i = 0; i < location.length(); i++) {
            if (location.charAt(i) == 'P') {
                int start = Math.max(0, i-K);
                int end = Math.min(i+K, N-1);
                for (int j = start; j <= end; j++) {
                    if (location.charAt(j) == 'H' && !isAte[j]) {
                        ans++;
                        isAte[j] = true;
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}