import java.io.*;
import java.util.*;

public class Main {
    static int N, homeCnt, height[][];
    static char[][] town;
    static boolean[][] visited;

    // 8방향: 수평(좌/우), 수직(상/하), 대각선
    static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        town = new char[N][N];
        int sx = 0, sy = 0;
        homeCnt = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                town[i][j] = input.charAt(j);
                if (town[i][j] == 'P') {
                    sx = i;
                    sy = j;
                } else if (town[i][j] == 'K') homeCnt++;
            }
        }

        height = new int[N][N];
        ArrayList<Integer> altLst = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                height[i][j] = Integer.parseInt(st.nextToken());
                if (!altLst.contains(height[i][j])) altLst.add(height[i][j]);
            }
        }

        Collections.sort(altLst);
        int size = altLst.size();
        int answer = Integer.MAX_VALUE;

        int r = 0;
        for (int l = 0; l < size; l++) {
            while (r < size && !canDeliver(sx, sy, altLst.get(l), altLst.get(r))) {
                r++;
            }

            if (r == size) break;
            answer = Math.min(answer, altLst.get(r) - altLst.get(l));
        }

        System.out.println(answer);
    }

    static boolean canDeliver(int sx, int sy, int low, int highMax) {
        int startH = height[sx][sy];
        if (startH < low || startH > highMax) return false;

        boolean[][] visited = new boolean[N][N];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[sx][sy] = true;
        q.offer(new int[] {sx, sy});

        int cnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (town[cur[0]][cur[1]] == 'K') cnt++;

            for (int i = 0; i < 8; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;

                int h = height[nx][ny];
                if (h < low || h > highMax) continue;

                visited[nx][ny] = true;
                q.offer(new int[] {nx, ny});
            }
        }

        return cnt == homeCnt;
    }
}