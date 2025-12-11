import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');
        int cnt = 1;
        while (!dq.isEmpty()) {
            if (cnt == K) {
                sb.append(dq.poll());
                if (!dq.isEmpty()) sb.append(", ");
                cnt = 1;
            } else {
                dq.add(dq.poll());
                cnt++;
            }
        }
        sb.append('>');
        System.out.println(sb);
    }
}