import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N, room[][], cnt;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine()); // 방의 크기

            StringTokenizer st;
            room = new int[N][N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int res = -1;
            int roomNumber = 1000001;
            // 각 방마다 그 방부터 시작하는 경우를 탐색하기 위해 2중 for문 사용
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    cnt = 1;
                    dfs(i, j);

                    if (res < cnt) { // 이동한 방 개수의 최대값 산출
                        roomNumber = room[i][j];
                        res = cnt;
                    } else if (res == cnt) { // 이동한 방의 개수가 같은 경우
                        roomNumber = Math.min(roomNumber, room[i][j]); // 방 번호를 번호가 작은 숫자로 설정
                    }
                }
            }

            System.out.println("#" + test_case + " " + roomNumber + " " + res);
        }
    }

    private static void dfs(int x, int y) {
        for(int i = 0; i < 4; i++) { // 상하좌우 4방향 탐색
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }

            // 다음 방 번호가 현재 방보다 정확히 1만큼 크다면 이동한 방 수 1 증가
            if(room[nx][ny] - room[x][y] == 1) {
                cnt++;
                dfs(nx, ny);
            }
        }
    }
}
