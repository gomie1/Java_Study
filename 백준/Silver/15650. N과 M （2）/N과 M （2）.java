import java.io.*;
import java.util.*;

public class Main {
    static int N, M, numbers[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[M];
        combination(0, 1);
        System.out.println(sb);
    }

    static void combination(int cnt, int start) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(numbers[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= N; i++) {
            numbers[cnt] = i;
            combination(cnt+1, i+1);
        }
    }
}