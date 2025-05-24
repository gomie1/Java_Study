import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, S, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ans = 0;
        subset(0, 0);
        
        if (S == 0) ans--;
        System.out.println(ans);
    }

    static void subset(int num, int index) {
        if (index == N) {
            if (num == S) ans++;
            return;
        }

        subset(num + arr[index], index + 1);
        subset(num, index + 1);
    }
}