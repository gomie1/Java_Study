import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        StringBuilder sb = new StringBuilder();
        visited = new boolean[N][N];
        int ans = 0;
        List<Integer> home = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    home.add(homeCnt(i, j, N));
                    ans++;
                }
            }
        }

        Collections.sort(home);
        sb.append(ans).append('\n');
        for (int i = 0; i < home.size(); i++) {
            sb.append(home.get(i)).append('\n');
        }

        System.out.println(sb);
    }

    static int homeCnt(int sx, int sy, int n) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        visited[sx][sy] = true;
        q.offer(new int[] {sx, sy});

        int cnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            cnt++;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || map[nx][ny] == 0) continue;

                q.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }

        return cnt;
    }
}