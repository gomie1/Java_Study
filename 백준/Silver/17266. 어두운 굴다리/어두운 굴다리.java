import java.io.*;
import java.util.*;

public class Main {
    static int N, M, pos[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        pos = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            pos[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1; // 가능한 최소 높이
        int right = N; // 가능한 최대 높이
        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(mid)) right = mid - 1;
            else left = mid + 1;
        }

        System.out.println(left);
    }

    static boolean isPossible(int height) {
        if (pos[0] > height || pos[M-1] + height < N) return false;
        for (int i = 1; i < M; i++) {
            if (pos[i] - pos[i-1] > 2 * height) return false;
        }
        return true;
    }
}