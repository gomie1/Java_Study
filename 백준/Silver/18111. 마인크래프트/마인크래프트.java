import java.io.*;
import java.util.*;

public class Main {
    static int N, M, B, map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int min = 256;
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] < min) min = map[i][j];
                else if (map[i][j] > max) max = map[i][j];
            }
        }

        int second = Integer.MAX_VALUE;
        int height = 0;
        for (int h = min; h <= max; h++) {
            int val = check(h);
            if (val >= 0 && val <= second) {
                second = val;
                height = h;
            }
        }

        System.out.println(second + " " + height);
    }

    static int check(int height) {
        int block = B;
        int time = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > height) {
                    int val = map[i][j] - height;
                    time += 2 * val;
                    block += val;
                } else if (map[i][j] < height) {
                    int val = height - map[i][j];
                    time += val;
                    block -= val;
                }
            }
        }

        if (block < 0) return -1;
        else return time;
    }
}