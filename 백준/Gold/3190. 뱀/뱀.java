import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        StringTokenizer st;
        boolean[][] apples = new boolean[N][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            apples[x][y] = true;
        }

        int L = Integer.parseInt(br.readLine());
        HashMap<Integer, Character> isChange = new HashMap<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            isChange.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }

        boolean[][] board = new boolean[N][N];
        board[0][0] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int time = 0;
        // 뱀의 초기 위치
        ArrayDeque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[] {0, 0});
        int d = 1; // 뱀의 초기 방향 (오른쪽)
        while(true) {
            time++;
            int[] cur = snake.peekFirst();

            // 1. 몸 길이를 늘려 머리를 다음 칸에 위치시키기
            int nx = cur[0] + dx[d];
            int ny = cur[1] + dy[d];
            snake.addFirst(new int[] {nx, ny});

            // 2. 만약 벽이나 자기자신의 몸과 부딪히면 게임 종료
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny]) break;
            board[nx][ny] = true;

            // 3. 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않음
            if (apples[nx][ny]) apples[nx][ny] = false;

            // 4. 만약 이동한 칸에 사과가 없다면, 몸 길이를 줄여서 꼬리가 위치한 칸을 비워줌
            else {
                int[] tail = snake.pollLast();
                board[tail[0]][tail[1]] = false;
            }

            // 5. 현재 시간이 끝난 후에 방향을 변경해야 한다면 변경
            if (isChange.containsKey(time)) {
                if (isChange.get(time) == 'L') d = (4+d-1) % 4;
                else d = (d+1) % 4;
            }
        }

        System.out.println(time);
    }
}