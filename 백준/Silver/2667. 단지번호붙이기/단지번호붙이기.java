import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = input[j] - '0';
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int total = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    q.offer(new int[] {i, j});
                    visited[i][j] = true;
                    int cnt = 0;
                    total++;

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        cnt++;

                        for (int k = 0; k < 4; k++) {
                            int nx = cur[0] + dx[k];
                            int ny = cur[1] + dy[k];

                            if (nx < 0 || nx >= N || ny < 0 || ny >= N ||
                                    visited[nx][ny] || map[nx][ny] == 0) continue;

                            q.offer(new int[] {nx, ny});
                            visited[nx][ny] = true;
                        }
                    }

                    ans.add(cnt);
                }
            }
        }

        Collections.sort(ans);

        StringBuilder sb = new StringBuilder();
        sb.append(total).append('\n');
        for (int v : ans) sb.append(v).append('\n');

        System.out.print(sb);
    }
}