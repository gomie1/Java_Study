import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        int x = 0;
        int y = 0;
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        q.offer(new int[] {x, y});
        visited[x][y] = true;

        int ans = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (map[cur[0]][cur[1]] == 'P') ans++;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M ||
                        visited[nx][ny] || map[nx][ny] == 'X') continue;

                q.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }

        if (ans == 0) System.out.println("TT");
        else System.out.println(ans);
    }
}