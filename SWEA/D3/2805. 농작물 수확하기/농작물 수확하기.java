import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int N, arr[][], res;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine()); // 농장의 크기

            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = str.charAt(j) - '0';
                }
            }

            visited = new boolean[N][N];
            res = arr[N/2][N/2];
            bfs(N/2, N/2);
            System.out.println("#" + test_case + " " + res);
        }
    }

    static void bfs(int start_x, int start_y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[start_x][start_y] = true;
        queue.add(new int[] {start_x, start_y, 0});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[2] >= N/2) break;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;

                queue.add(new int[] {nx, ny, cur[2]+1});
                visited[nx][ny] = true;
                res += arr[nx][ny];
            }
        }
    }
}