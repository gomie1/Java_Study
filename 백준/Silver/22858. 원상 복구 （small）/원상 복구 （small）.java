import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] S = new int[N+1]; // 섞인 후
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int[] D = new int[N+1]; // 섞는 규칙
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }

        // S부터 시작해서 K번 카드 섞기
        for (int i = 0; i < K; i++) {
            int[] tmp = new int[N+1];
            for (int j = 1; j <= N; j++) {
                tmp[D[j]] = S[j];
            }

            for (int j = 1; j <= N; j++) {
                S[j] = tmp[j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(S[i]).append(" ");
        }
        System.out.println(sb);
    }
}