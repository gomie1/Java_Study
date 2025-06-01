import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (find(Integer.parseInt(st.nextToken()))) sb.append("1\n");
            else sb.append("0\n");
        }

        System.out.println(sb);
    }

    static boolean find(int num) {
        int left = 0;
        int right = N-1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (num == A[mid]) return true;
            else if (num < A[mid]) right = mid - 1;
            else left = mid + 1;
        }

        return false;
    }
}