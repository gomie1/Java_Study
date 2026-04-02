import java.io.*;
import java.util.*;

public class Main {
    static int N, M, arr[][], ans;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                visited[i][j] = false;
                poly(i, j);
            }
        }

        System.out.println(ans);
    }

    static void dfs(int x, int y, int cnt, int sum) {
        if (cnt == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(nx, ny, cnt+1, sum+arr[nx][ny]);
            visited[nx][ny] = false;
        }
    }

    static void poly(int x, int y) {
        // ㅜ
        if (y-1 >= 0 && y+1 < M && x+1 < N) ans = Math.max(ans, arr[x][y-1] + arr[x][y] + arr[x][y+1] + arr[x+1][y]);

        // ㅓ
        if (x-1 >= 0 && x+1 < N && y-1 >= 0) ans = Math.max(ans, arr[x-1][y] + arr[x][y] + arr[x+1][y] + arr[x][y-1]);

        // ㅗ
        if (y-1 >= 0 && y+1 < M && x-1 >= 0) ans = Math.max(ans, arr[x][y-1] + arr[x][y] + arr[x][y+1] + arr[x-1][y]);

        // ㅏ
        if (x-1 >= 0 && x+1 < N && y+1 < M) ans = Math.max(ans, arr[x-1][y] + arr[x][y] + arr[x+1][y] + arr[x][y+1]);
    }
}