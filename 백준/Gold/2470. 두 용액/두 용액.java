import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // -99 -2 -1 4 98

        int left = 0;
        int right = N-1;
        long min = Long.MAX_VALUE;
        long[] res = new long[2];
        while (left < right) {
            long sum = arr[left] + arr[right];
            if (Math.abs(sum) < Math.abs(min)) {
                min = sum;
                res[0] = arr[left];
                res[1] = arr[right];
            }

            if (sum < 0) left++;
            else right--;
        }

        Arrays.sort(res);
        System.out.println(res[0] + " " + res[1]);
    }
}