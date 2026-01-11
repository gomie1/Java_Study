import java.io.*;
import java.util.*;

public class Main {
    static int N, video[][];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        video = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                video[i][j] = input.charAt(j) - '0';
            }
        }

        zip(0, 0, N);
        System.out.println(sb);
    }

    static void zip(int x, int y, int size) {
        // 1. 현재 범위 내에 색이 다른 점이 있는지 확인
        int color = video[x][y];
        boolean isSame = true;
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (video[i][j] != color) {
                    isSame = false;
                    break;
                }
            }
        }

        // 2. 범위 내의 색이 모두 동일하다면 압축
        if (isSame) {
            sb.append(color);
            return;
        }

        sb.append('(');
        // 3. 범위 내의 색이 동일하지 않다면, 영상 쪼개기
        zip(x, y, size/2);
        zip(x, y + size/2, size/2);
        zip(x + size/2, y, size/2);
        zip(x + size/2, y + size/2, size/2);
        sb.append(')');
    }
}