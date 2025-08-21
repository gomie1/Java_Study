import java.io.*;
import java.util.*;

public class Main {
    static int N, M, arr[][], ans;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
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

        visited = new boolean[N][M];
        ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 'ㅗ' 모양
                if (i-1 >= 0 && j-1 >= 0 && j+1 < M) ans = Math.max(ans, arr[i][j] + arr[i][j-1] + arr[i][j+1] + arr[i-1][j]);

                // 'ㅜ' 모양
                if (i+1 < N && j-1 >= 0 && j+1 < M) ans = Math.max(ans, arr[i][j] + arr[i][j-1] + arr[i][j+1] + arr[i+1][j]);

                // 'ㅏ' 모양
                if (i-1 >= 0 && i+1 < N && j+1 < M) ans = Math.max(ans, arr[i][j] + arr[i-1][j] + arr[i+1][j] + arr[i][j+1]);

                // 'ㅓ' 모양'
                if (i-1 >= 0 && i+1 < N && j-1 >= 0) ans = Math.max(ans, arr[i][j] + arr[i-1][j] + arr[i+1][j] + arr[i][j-1]);
            }
        }

        System.out.println(ans);
    }

    static void dfs(int x, int y, int cnt, int sum) {
        if (cnt > 4) return;
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
}