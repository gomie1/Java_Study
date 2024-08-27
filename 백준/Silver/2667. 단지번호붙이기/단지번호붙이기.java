import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 우 하 좌 상
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int N, map[][], cnt;
    static boolean[][] visited;
    static ArrayList<Integer> homeCnt;

    static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 지도의 크기

        // 지도 정보 입력 받기
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        int res = 0;
        visited = new boolean[N][N];
        homeCnt = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    cnt = 1;
                    bfs(i, j);
                    res++;
                    homeCnt.add(cnt);
                }
            }
        }

        Collections.sort(homeCnt);
        System.out.println(res);
        for(int home : homeCnt) {
            System.out.println(home);
        }
    }

    /* 1. visited 배열을 사용하는 방법 */
    private static void bfs(int start_x, int start_y) {
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(start_x, start_y));
        visited[start_x][start_y] = true;

        while(!queue.isEmpty()) {
            Pos cur = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    cnt++;
                    queue.offer(new Pos(nx, ny));
                }
            }
        }
    }
}
