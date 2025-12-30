import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!q.isEmpty()) {
            int cnt = 0;
            while (cnt < K-1) {
                q.offer(q.poll());
                cnt++;
            }

            sb.append(q.poll()).append(", ");
        }

        sb.delete(sb.length()-2, sb.length()).append(">");
        System.out.println(sb);
    }
}