import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    // 우, 하, 좌, 상
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int N, arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine()); // 달팽이의 크기

            arr = new int[N][N]; // 달팽이 초기화
            arr[0][0] = 1; // 1부터 시작
            dfs(0, 0, 0, 2);

            System.out.println("#" + test_case);
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static void dfs(int x, int y, int dir, int value) {
        // value가 N*N보다 크다는 것은 달팽이의 값이 모두 채워진 것이므로 종료
        if(value > N*N) {
            return;
        }

        // 현재 방향대로 다음 위치 생성
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        // 다음 위치가 범위를 벗어나지 않고, 값이 0이라면 값을 채워주고 다음 위치로 이동
        if(nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] == 0) {
            arr[nx][ny] = value;
            dfs(nx, ny, dir, value+1);
        }
        else { // 다음 위치가 범위를 벗어났거나, 값이 이미 채워진 경우 방향을 바꿔줌
            dfs(x, y, (dir + 1) % 4, value);
        }
    }
}