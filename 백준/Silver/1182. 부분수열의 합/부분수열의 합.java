import java.io.*;
import java.util.*;

public class Main {
    static int arr[], ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ans = 0;
        subset(0, 0, N, S);
        System.out.println(S == 0 ? ans-1 : ans);
    }

    static void subset(int sum, int cnt, int n, int s) {
        if (cnt == n) {
            if (sum == s) ans++;
            return;
        }

        subset(sum+arr[cnt], cnt+1, n, s);
        subset(sum, cnt+1, n, s);
    }
}