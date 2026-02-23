import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] check = new boolean[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            check[a][b] = true;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (check[i][k] && check[k][j]) check[i][j] = true;
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                if (check[i][j] || check[j][i]) cnt++;
            }
            
            if (cnt == N-1) ans++; // 본인을 제외한 모든 사람과의 관계가 있다면 순위를 알 수 있음
        }

        System.out.println(ans);
    }
}