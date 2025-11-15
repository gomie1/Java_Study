import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] itemCnt = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            itemCnt[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 각 노드별 거리 기록
        int[][] dist = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], len);
            dist[b][a] = Math.min(dist[b][a], len);
        }

        // 2. Floyd-Warshall
        // 어떤 지역에 아이템이 많아도 그 지역에 도달할 수 없다면 그 아이템은 절대 먹을 수 없음
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // 3. 각 출발지(i)에 대해 m 이내에 갈 수 있는 지역들의 아이템 합 구하기
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] <= m) sum += itemCnt[j];
            }
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}