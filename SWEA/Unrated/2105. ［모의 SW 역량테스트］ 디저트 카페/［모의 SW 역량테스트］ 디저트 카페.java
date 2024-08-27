import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    // 대각선 4방향 (마름모 모양)
    static int[] dx = {-1, 1, 1, -1};
    static int[] dy = {1, 1, -1, -1};

    static int N, map[][], res;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine()); // 지도의 크기

            // 디저트 가게 정보 입력 받기
            map = new int[N][N];
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            res = -1;
            for(int i = 1; i < N-1; i++) {
                for(int j = 0; j < N-2; j++) {
                    visited = new boolean[101];
                    visited[map[i][j]] = true;
                    dfs(i, j, 1, i, j, 0);
                }
            }
            System.out.println("#" + test_case + " " + res);
        }
    }

    private static void dfs(int cur_x, int cur_y, int cnt, int start_x, int start_y, int dir) {
        for(int i = dir; i < 4; i++) {
            int nx = cur_x + dx[i];
            int ny = cur_y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }

            if(nx == start_x && ny == start_y && cnt >= 4) {
                res = Math.max(res, cnt);
                return;
            }
            
            if(!visited[map[nx][ny]]) {
                visited[map[nx][ny]] = true;
                dfs(nx, ny, cnt + 1, start_x, start_y, i);
                visited[map[nx][ny]] = false;
            }
        }
    }
}
