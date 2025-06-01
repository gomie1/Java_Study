import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] mtrxA, mtrxB;
    static boolean[][] visitedA, visitedB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        mtrxA = new char[N][];
        for (int i = 0; i < N; i++) {
            mtrxA[i] = br.readLine().toCharArray();
        }

        mtrxB = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (mtrxA[i][j] == 'G') mtrxB[i][j] = 'R';
                else mtrxB[i][j] = mtrxA[i][j];
            }
        }

        int[] ans = new int[2];
        visitedA = new boolean[N][N];
        visitedB = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitedA[i][j]) {
                    bfs(true, i, j, mtrxA[i][j]);
                    ans[0]++;
                }

                if (!visitedB[i][j]) {
                    bfs(false, i, j, mtrxB[i][j]);
                    ans[1]++;
                }
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }

    static void bfs(boolean flag, int start_x, int start_y, char color) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {start_x, start_y});
        if (flag) visitedA[start_x][start_y] = true;
        else visitedB[start_x][start_y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (flag) {
                    if (visitedA[nx][ny] || mtrxA[nx][ny] != color) continue;
                    visitedA[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                } else {
                    if (visitedB[nx][ny] || mtrxB[nx][ny] != color) continue;
                    visitedB[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }
}