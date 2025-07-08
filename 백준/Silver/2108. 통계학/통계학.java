import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] count = new int[8001];
        int sum = 0;
        int maxCount = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            count[arr[i] + 4000]++;
            
            if (maxCount < count[arr[i] + 4000]) {
                maxCount = count[arr[i] + 4000];
            }
        }
        
        Arrays.sort(arr);

        int mode = 0;
        boolean first = true;
        for (int i = 0; i < 8001; i++) {
            if (count[i] == maxCount) {
                if (first) {
                    mode = i - 4000;
                    first = false;
                } else {
                    mode = i - 4000;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Math.round((double) sum / N)).append('\n');
        sb.append(arr[N/2]).append('\n');
        sb.append(mode).append('\n');
        sb.append(arr[N-1] - arr[0]);
        System.out.println(sb);
    }
}