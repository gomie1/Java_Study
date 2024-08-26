import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] mtrx;
    static boolean[][] visited;
    static int N, M, cheese = 0;
    static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 치즈 입력 받기
        mtrx = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                mtrx[i][j] = Integer.parseInt(st.nextToken());

                // 치즈 개수 카운팅
                if(mtrx[i][j] == 1) {
                    cheese++;
                }
            }
        }

        int cnt = 0;
        int time = 0;
        while(cheese != 0){
            cnt = cheese;
            time++;
            visited = new boolean[N][M];
            bfs();
        }

        System.out.println(time);
        System.out.println(cnt);
    }

    private static void bfs() {
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(0, 0));
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            Pos cur = queue.poll();

            for(int i = 0; i < 4; i++) { // 4방향 탐색
                // 다음 위치 계산
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                // 다음 위치가 범위안에 있고, 방문한 적이 없다면
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == false) {
                    visited[nx][ny] = true; // 방문 처리
                    if(mtrx[nx][ny] == 0) { // 다음 위치가 공기라면
                        queue.offer(new Pos(nx, ny)); // 위치를 큐에 삽입
                    } else { // 다음 위치가 치즈라면
                        cheese--; // 치즈의 개수를 1개 감소시키고
                        mtrx[nx][ny] = 0; // 공기로 변경 (치즈 녹이기)
                    }
                }
            }
        }
    }
}