import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int OFFSET = 10_000_000;
        int[] card = new int[OFFSET * 2 + 1];
        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(st.nextToken());
            card[idx + OFFSET]++;
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int idx = Integer.parseInt(st.nextToken()) + OFFSET;
            sb.append(card[idx]).append(" ");
        }

        System.out.println(sb);
    }
}