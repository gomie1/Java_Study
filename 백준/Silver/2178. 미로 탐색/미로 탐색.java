import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N, M, map[][], res;
    static boolean visited[][], flag;

    static class Pos{
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        visited = new boolean[N][M];
        flag = false;
        res = 0;
        loop: for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    bfs(i, j);

                    if(flag) {
                        System.out.println(map[N-1][M-1]);
                        break loop;
                    }
                }
            }
        }
    }

    private static void bfs(int start_x, int start_y) {
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(start_x, start_y));
        visited[start_x][start_y] = true;

        loop: while(!q.isEmpty()) {
            Pos cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 0 || visited[nx][ny]) continue;

                map[nx][ny] = map[cur.x][cur.y] + 1;
                q.offer(new Pos(nx, ny));
                visited[nx][ny] = true;

                if(nx == N-1 && ny == M-1) {
                    flag = true;
                    break loop;
                }
            }
        }
    }
}
