import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 1;
        int sum = arr[start];
        int ans = Integer.MAX_VALUE;
        while (start < N && end <= N) {
            if (sum < S)  {
                if (end >= N) break; // 아직 sum이 S보다 작은데 이미 end가 끝까지 왔다면 더이상 커질 수 없음 (종료)

                sum += arr[end];
                if (S <= sum) {
                    ans = Math.min(ans, end - start + 1);
                    if (ans == 1) break;
                }
                end++;
            } else {
                ans = Math.min(ans, end - start);
                if (ans == 1) break;
                sum -= arr[start++];
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }
}