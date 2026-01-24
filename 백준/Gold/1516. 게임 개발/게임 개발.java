import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] buildings = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            buildings[i] = new ArrayList<>();
        }
        int[] time = new int[N+1];
        int[] degree = new int[N+1];
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            time[i] = Integer.parseInt(input[0]);
            for (int j = 1; j < input.length - 1; j++) {
                buildings[Integer.parseInt(input[j])].add(i);
                degree[i]++;
            }
        }

        ArrayDeque<int[]> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) dq.offer(new int[] {i, time[i]});
        }

        int[] ans = new int[N+1];
        int[] maxTime = new int[N+1];
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            ans[cur[0]] = cur[1];

            for (int nxt : buildings[cur[0]]) {
                maxTime[nxt] = Math.max(maxTime[nxt], cur[1]);
                if (--degree[nxt] == 0) dq.offer(new int[] {nxt, maxTime[nxt]+time[nxt]});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(ans[i]).append('\n');
        }
        System.out.println(sb);
    }
}