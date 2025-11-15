import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] x = new int[N+1];
        for (int i = 1; i <= N; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] h = new int[N+1];
        for (int i = 1; i <= N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        q.offer(S);
        visited[S] = true;

        int left = Math.max(0, S-1);
        int right = Math.min(S+1, N);
        while (!q.isEmpty()) {
            int cur = q.poll();
            int[] reach = {x[cur]-h[cur], x[cur]+h[cur]};

            // 왼쪽 체크
            while (left >= 1 && x[left] >= reach[0]) {
                q.add(left);
                visited[left--] = true;
            }

            // 오른쪽 체크
            while (right <= N && x[right] <= reach[1]) {
                q.add(right);
                visited[right++] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (visited[i]) sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}