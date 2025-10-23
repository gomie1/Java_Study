import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            return o2[1] - o1[1];
        });
        for (int i = 1; i <= N; i++) {
            pq.offer(new int[] {Integer.parseInt(st.nextToken()), i});
        }

        List<int[]> list = new LinkedList<>();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (list.isEmpty()) list.add(cur);
            else {
                int cnt = 0;
                for (int i = 0; i <= list.size(); i++) {
                    if (cnt == cur[0]) {
                        list.add(i, cur);
                        break;
                    }

                    if (cnt < cur[0] && cur[1] < list.get(i)[1]) cnt++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(list.get(i)[1]).append(" ");
        }

        System.out.println(sb);
    }
}