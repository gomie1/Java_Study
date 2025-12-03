import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] info = new int[N][2]; // 순서, 나이
        String[] name = new String[N]; // 이름
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = i;
            info[i][1] = Integer.parseInt(st.nextToken());
            name[i] = st.nextToken();
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        for (int i = 0; i < N; i++) {
            pq.offer(info[i]);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            sb.append(cur[1]).append(" ").append(name[cur[0]]).append('\n');
        }

        System.out.println(sb);
    }
}