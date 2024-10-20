import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];
            int x = 0, y = 0, dir = 0;
            for (int i = 1; i <= N*N; i++) {
                arr[x][y] = i;

                x += dx[dir];
                y += dy[dir];

                if(x < 0 || x >= N || y < 0 || y >= N || arr[x][y] != 0) {
                    x -= dx[dir];
                    y -= dy[dir];

                    dir = (dir + 1) % 4;
                    
                    x += dx[dir];
                    y += dy[dir];
                }
            }

            System.out.println("#" + test_case + " ");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}