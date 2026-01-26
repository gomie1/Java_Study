import java.io.*;
import java.util.*;

public class Main {
    static int M, N, map[][], dp[][];

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[M][N]; // (x, y)에서 목적지까지 갈 수 있는 경로의 수
        for (int i = 0; i < M; i++) {
            Arrays.fill(dp[i], -1);
        }

        dfs(0, 0);
        System.out.println(dp[0][0]);
    }

    static int dfs(int x, int y) {
        // 1. 기저 조건: 목적지에 도착하면 종료
        if (x == M-1 && y == N-1) return 1; // 경로 1개를 찾았으므로 1을 반환

        // 2. 메모이제이션: 이미 계산해본 적이 있는 칸이라면?
        if (dp[x][y] != -1) return dp[x][y]; // 더 이상 이동하지 않고 적어둔 값 그대로 반환

        // 3. 탐색 및 계산: 처음 방문한 칸이라면?
        dp[x][y] = 0; // 0으로 초기화 (방문 표시)
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= M || ny < 0 || ny >= N || map[x][y] <= map[nx][ny]) continue;
            dp[x][y] += dfs(nx, ny); // 다음 칸에서 목적지까지 가는 경로의 수 더하기
        }

        return dp[x][y];
    }
}