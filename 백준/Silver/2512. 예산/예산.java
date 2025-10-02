import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (max < arr[i]) max = arr[i];
        }
        int total = Integer.parseInt(br.readLine());

        int low = 0; // 상한액의 최소값
        int high = max; // 상한액의 최대값 (= 지방들의 요청 예산 중 최댓값)
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2; // 상한액

            // 상한액 적용 총 예산 계산
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] <= mid) sum += arr[i];
                else sum += mid;
            }

            // 예산이 충족하는 경우 (mid = 가능한 상한액)
            if (sum <= total) {
                ans = Math.max(ans, mid);
                low = mid + 1;
            } else high = mid - 1; // 예산이 초과하는 경우
        }

        System.out.println(ans);
    }
}