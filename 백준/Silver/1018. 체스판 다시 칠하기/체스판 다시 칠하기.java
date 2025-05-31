import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;

    static char[][] chessW = new char[][] {
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
    };
    static char[][] chessB = new char[][] {
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int ans = 64; // 8 * 8
        for (int i = 0; i < N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                int cnt = check(i, j);
                if (cnt < ans) ans = cnt;
            }
        }

        System.out.println(ans);
    }

    static int check (int start_x, int start_y) {
        int cntB = 0;
        int cntW = 0;
        for (int i = start_x; i < start_x + 8; i++) {
            for (int j = start_y; j < start_y + 8; j++) {
                if (board[i][j] != chessB[i - start_x][j - start_y]) cntB++;
                if (board[i][j] != chessW[i - start_x][j - start_y]) cntW++;
            }
        }

        return Math.min(cntB, cntW);
    }
}