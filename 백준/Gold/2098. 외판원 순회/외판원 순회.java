import java.io.*;
import java.util.*;

public class Main {
    static int N, W[][], dp[][];
    static final int INF = 16_000_000; // 최대 비용(100만) * N(16)

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        W = new int[N][N];
        // dp[현재도시][방문상태]: 현재 도시에 있고, 남은 도시들을 모두 방문하고 다시 시작점으로 돌아가는 데 드는 최소 비용
        dp = new int[N][1 << N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }

            // dp 테이블을 -1로 초기화 (방문하지 않았음을 표시)
            Arrays.fill(dp[i], -1);
        }

        System.out.println(tsp(0, 1)); // 0번 도시에서 시작, 0번 도시 방문 체크(1 << 0)후 출발
    }

    static int tsp(int cur, int visit) {
        // 1. 모든 도시를 방문했는지 확인 (비트가 모두 1인지)
        if (visit == (1 << N) - 1) {
            // 마지막 도시에서 시작점(0번)으로 돌아갈 수 있는지 확인
            if (W[cur][0] == 0) return INF;
            return W[cur][0];
        }

        // 2. 이미 계산한 적이 있다면 그 값을 즉시 반환
        if (dp[cur][visit] != -1) return dp[cur][visit];

        // 계산 시작 전 초기화
        dp[cur][visit] = INF;

        // 3. 다음으로 방문할 도시를 하나씩 찾아봄
        for (int nxt = 0; nxt < N; nxt++) {
            // 다음 도시를 아직 방문하지 않았고, 현재 도시에서 다음 도시로 갈 수 있다면 비용 갱신
            if ((visit & (1 << nxt)) == 0 && W[cur][nxt] != 0) {
                dp[cur][visit] = Math.min(dp[cur][visit], tsp(nxt, visit | (1 << nxt)) + W[cur][nxt]);
            }
        }

        return dp[cur][visit];
    }
}