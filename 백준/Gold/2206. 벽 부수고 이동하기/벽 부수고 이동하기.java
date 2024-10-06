import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int N, M, res;
    private static char[][] map;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            map[i] = input.toCharArray();
        }

        visited = new boolean[N][M][2];
        res = -1;
        bfs(0, 0, 1);
        System.out.println(res);
    }

    private static void bfs(int start_x, int start_y, int cnt) {
        Queue<int[]> queue = new LinkedList<>();
        visited[start_x][start_y][0] = true;
        queue.offer(new int[] {start_x, start_y, cnt, 0});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == N-1 && cur[1] == M-1) {
                res = cur[2];
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                // 다음 위치가 벽일 때 (부수고 지나가기 vs 패스하기)
                if(map[nx][ny] == '1') {
                    if(cur[3] == 0) { // 아직 벽을 부순 적이 없다면
                        visited[nx][ny][1] = true; // 벽을 부수고 지나감
                        queue.offer(new int[] {nx, ny, cur[2]+1, 1});
                    }
                } else { // 벽이 아니면 지나가기
                    if(!visited[nx][ny][cur[3]]) {
                        visited[nx][ny][cur[3]] = true;
                        queue.offer(new int[] {nx, ny, cur[2]+1, cur[3]});
                    }
                }
            }
        }
    }
}
