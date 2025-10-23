import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] line = new int[N];
        for (int i = 0; i < N; i++) {
            int cur = i + 1;
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (line[j] == 0) {
                    if (cnt == arr[i]) {
                        line[j] = cur;
                        break;
                    }
                    cnt++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : line) sb.append(n).append(" ");
        System.out.println(sb);
    }
}