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

        boolean[][] visited = new boolean[M][N];
        visited[0][0] = true;

        int cnt = 0;
	    int x = 0, y = 0;
        for (int i = 0; i < M*N-1; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny]) {
                dir = (dir + 1) % 4;
                cnt++;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
            visited[nx][ny] = true;
        }

        System.out.println(cnt);
    }
}