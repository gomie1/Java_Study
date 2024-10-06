import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int R, C, res;
    private static char[][] map;
    private static boolean[][] visited, vStar;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 숲 정보 입력받기
        map = new char[R][C];
        int x = 0, y = 0;
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);

                if(map[i][j] == 'S') { // 고슴도치의 초기 위치 저장
                    x = i;
                    y = j;
                }
            }
        }

        visited = new boolean[R][C];
        res = 0;
        bfs(x, y, 0);

        if(res == 0) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(res);
        }
    }

    private static void bfs(int start_x, int start_y, int time) {
        Queue<int[]> queue = new LinkedList<>();
        visited[start_x][start_y] = true;
        queue.offer(new int[] {start_x, start_y, time});

        while(!queue.isEmpty()) {
            water();

            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] pos = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = pos[0] + dx[i];
                    int ny = pos[1] + dy[i];

                    // 다음 위치가 범위를 벗어나거나 방문한 곳 또는 돌/물이라면 패스
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny] || map[nx][ny] == 'X' || map[nx][ny] == '*')
                        continue;

                    if (map[nx][ny] == 'D') {
                        res = pos[2] + 1;
                        return;
                    }
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, pos[2] + 1});
                }
            }
        }
    }

    private static void water() {
        vStar = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == '*' && !vStar[i][j]) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

                        if(map[nx][ny] == '.') {
                            vStar[nx][ny] = true;
                            map[nx][ny] = '*';
                        }
                    }
                }
            }
        }
    }
}