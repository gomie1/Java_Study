import java.io.*;
import java.util.*;

public class Main {
    static int N, M, arr[];
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isSelected = new boolean[N+1];
        arr = new int[M];
        permutation(0);
        System.out.println(sb);
    }

    static void permutation(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!isSelected[i]) {
                arr[cnt] = i;
                isSelected[i] = true;
                permutation(cnt+1);
                isSelected[i] = false;
            }
        }
    }
}