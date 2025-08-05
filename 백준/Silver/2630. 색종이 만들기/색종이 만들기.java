import java.io.*;
import java.util.*;

public class Main {
    static int paper[][], white = 0, blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        paper = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);
        sb.append(white).append('\n').append(blue);
        System.out.print(sb);
    }

    static void divide(int x, int y, int size) {
        if (isSameColor(x, y, size)) {
            if (paper[x][y] == 0) white++;
            else blue++;
            return;
        }

        int newSize = size / 2;

        divide(x, y, newSize); // 좌상
        divide(x, y + newSize, newSize); // 우상
        divide(x + newSize, y, newSize); // 좌하
        divide(x + newSize, y + newSize, newSize); // 우하
    }

    static boolean isSameColor(int x, int y, int size) {
        int color = paper[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color) return false;
            }
        }

        return true;
    }
}