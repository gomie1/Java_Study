import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(P);
        int[] sum = new int[N];
        sum[0] = P[0];
        int ans = P[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + P[i];
            ans += sum[i];
        }

        System.out.println(ans);
    }
}