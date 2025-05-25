import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int idx = K - 1; // 2
        while (true) {
            sb.append(arr.get(idx));
            if (N > 1) sb.append(", ");

            arr.remove(arr.get(idx));
            N--;
            if (N == 0) break;

            idx += K - 1;
            if (idx >= N) idx %= N;
        }

        sb.append(">");
        System.out.println(sb);
    }
}