import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int zero = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 0) zero++;
        }

        if (zero == N) {
            System.out.println("SAD");
            return;
        }

        int val = 0;
        for (int i = 0; i < X; i++) {
            val += arr[i];
        }

        int left = 0;
        int max = val;
        int cnt = 1;
        for (int right = X; right < N; right++) {
            val = val - arr[left++] + arr[right];

            if (max < val) {
                max = val;
                cnt = 1;
            } else if (max == val) cnt++;
        }

        System.out.println(max);
        System.out.println(cnt);
    }
}