import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N, arr[][];
    static boolean[][] visited;

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 배열의 크기

        // 2차원 배열 입력 받기
        arr = new int[N][N];
        StringTokenizer st;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]); // 높이의 최대값 찾기
                min = Math.min(min, arr[i][j]); // 높이의 최소값 찾기
            }
        }

        // 비 내리기 -> bfs 반복하며 최대값 찾기
        int res = 0;
        for(int h = 0; h < max; h++) {
            visited = new boolean[N][N];
            int cnt = 0;
            rain(h);
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            res = Math.max(res, cnt);
        }
        System.out.println(res);
    }

    private static void rain(int h) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] <= h) { // 현재 위치가 침수된 높이보다 작거나 같다면
                    visited[i][j] = true; // 방문처리
                }
            }
        }
    }
    private static void bfs(int start_x, int start_y) {
        Queue<Pos> q = new LinkedList<>(); // 큐 생성
        q.offer(new Pos(start_x, start_y)); // 시작 위치 큐에 삽입

        while(!q.isEmpty()) { // 큐가 비지않을 동안 반복
            Pos cur = q.poll(); // 현재 위치 큐에서 꺼내기

            for(int i = 0; i < 4; i++) { // 4방향 탐색
                // 다음 위치 계산
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                // 다음 위치가 범위를 벗어나거나 방문했다면 패스
                if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;

                visited[nx][ny] = true; // 조건을 만족한다면 다음 위치 방문처리 후
                q.offer(new Pos(nx, ny)); // 큐에 삽입
            }
        }
    }
}
