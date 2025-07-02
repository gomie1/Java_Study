import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] card = new int[20000001];
        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(st.nextToken());
            if (idx < 0) idx = (idx * -1) + 10000000;
            card[idx]++;
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int idx = Integer.parseInt(st.nextToken());
            if (idx < 0) idx = (idx * -1) + 10000000;
            sb.append(card[idx]).append(" ");
        }

        System.out.println(sb);
    }
}