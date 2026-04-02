import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int dir = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        boolean[][] visited = new boolean[M][N];
        visited[0][0] = true;

        int cnt = 0;
        for (int i = 0; i < M*N-1; i++) {
            int[] cur = q.poll();

            int nx = cur[0] + dx[dir];
            int ny = cur[1] + dy[dir];

            if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny]) {
                dir = (dir + 1) % 4;
                cnt++;
                nx = cur[0] + dx[dir];
                ny = cur[1] + dy[dir];
            }

            q.add(new int[] {nx, ny});
            visited[nx][ny] = true;
        }

        System.out.println(cnt);
    }
}