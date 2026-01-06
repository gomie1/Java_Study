import java.io.*;

public class Main {
    static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        star = new char[N][N];
        drawStar(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (star[i][j] == '*') sb.append(star[i][j]);
                else sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void drawStar(int x, int y, int n) {
        if (n == 1) {
            star[x][y] = '*';
            return;
        }

        int size = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                drawStar(x + (i * size), y + (j * size), size);
            }
        }
    }
}