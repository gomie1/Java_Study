import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] score = new int[N][4];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            score[i][0] = Integer.parseInt(st.nextToken()); // country
            score[i][1] = Integer.parseInt(st.nextToken()); // gold
            score[i][2] = Integer.parseInt(st.nextToken()); // silver
            score[i][3] = Integer.parseInt(st.nextToken()); // bronze
        }

        // 금 -> 은 -> 동 순으로 정렬
        Arrays.sort(score, (o1, o2) -> {
            if (o1[1] != o2[1]) return o2[1] - o1[1];
            if (o1[2] != o2[2]) return o2[2] - o1[2];
            return o2[3] - o1[3];
        });

        if (score[0][0] == K) {
            System.out.println(1);
            return;
        }

        int rank = 1;
        for (int i = 1; i < N; i++) {
            if (score[i][0] == K) {
                System.out.println(rank);
                return;
            }

            if (score[i][1] != score[i-1][1] || score[i][2] != score[i-1][2] || score[i][3] != score[i-1][3]) rank = i+1;
        }
    }
}