import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> ladder = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        HashMap<Integer, Integer> snake = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[101];
        q.offer(new int[] {1, 0});
        visited[1] = true;

        int ans = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == 100) {
                ans = cur[1];
                break;
            }

            for (int i = 1; i <= 6; i++) {
                int val = cur[0] + i;
                if (val > 100 || visited[val]) continue;

                if (ladder.containsKey(val)) {
                    q.offer(new int[] {ladder.get(val), cur[1] + 1});
                    visited[ladder.get(val)] = true;
                } else if (snake.containsKey(val)) {
                    q.offer(new int[] {snake.get(val), cur[1] + 1});
                    visited[snake.get(val)] = true;
                } else {
                    q.offer(new int[] {val, cur[1] + 1});
                    visited[val] = true;
                }
            }
        }

        System.out.println(ans);
    }
}