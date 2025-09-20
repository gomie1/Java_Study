import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] infos = new int[N][4]; // [국가번호, 금, 은, 동]
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            infos[i] = new int[] {
                num,
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            };
        }

        // 금 -> 은 -> 동 내림차순 정렬
        Arrays.sort(infos, (a, b) -> {
            if (a[1] != b[1]) return b[1] - a[1];
            if (a[2] != b[2]) return b[2] - a[2];
            return b[3] - a[3];
        });

        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (i > 0) {
                if (infos[i-1][1] != infos[i][1] ||
                    infos[i-1][2] != infos[i][2] ||
                    infos[i-1][3] != infos[i][3]) rank = i + 1;
            }

            if (infos[i][0] == K) {
                System.out.println(rank);
                break;
            }
        }
    }
}