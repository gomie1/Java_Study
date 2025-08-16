import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] graph = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[N];

            q.offer(i);

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int j = 0; j < N; j++) {
                    if (graph[cur][j] == 1 && !visited[j]) {
                        q.offer(j);
                        visited[j] = true;
                        result[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] row : result) {
            for (int val : row) sb.append(val).append(" ");
            sb.append('\n');
        }

        System.out.print(sb);
    }
}