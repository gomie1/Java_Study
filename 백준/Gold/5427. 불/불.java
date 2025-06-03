import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static char[][] map;
    static Queue<int[]> fire;
    static boolean[][] visited; // 상근이가 이동한 기록 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][];
            fire = new LinkedList<>();
            visited = new boolean[h][w];
            int x = 0, y = 0;
            for (int j = 0; j < h; j++) {
                map[j] = br.readLine().toCharArray();
                for (int k = 0; k < w; k++) {
                    if (map[j][k] == '@') {
                        x = j;
                        y = k;
                    }
                    else if (map[j][k] == '*') fire.offer(new int[] {j, k});
                }
            }

            String ans = move(x, y);
            sb.append(ans);
        }

        System.out.println(sb);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static String move (int start_x, int start_y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {start_x, start_y, 0});
        visited[start_x][start_y] = true;

        while (!q.isEmpty()) {
            // 1. 불 퍼뜨리기
            int len = fire.size();
            for (int i = 0; i < len; i++) {
                int[] f = fire.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = f[0] + dx[j];
                    int ny = f[1] + dy[j];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == '#' || map[nx][ny] == '*') continue;

                    fire.offer(new int[] {nx, ny});
                    map[nx][ny] = '*';
                }
            }

            // 2. 상근이 이동
            len = q.size();
            for (int i = 0; i < len; i++) {
                int[] cur = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) return Integer.toString(cur[2] + 1) + "\n";
                    if (visited[nx][ny] || map[nx][ny] == '#' || map[nx][ny] == '*') continue;

                    q.offer(new int[] {nx, ny, cur[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }

        return "IMPOSSIBLE\n";
    }
}