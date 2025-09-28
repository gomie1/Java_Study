import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dist = new int[N-1];
        for (int i = 0; i < N-1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] price = new int[N];
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0; // 총 비용
        int sumDist = 0; // 누적 거리
        int cur = 0; // 현재 도시의 인덱스
        while (cur < N-1) {
            if (price[cur] > price[cur+1]) {
                ans += price[cur] * dist[cur];
                cur++;
            } else {
                int cnt = 0; // 주유를 건너뛸 도시의 개수
                for (int i = cur; i < N-1; i++) {
                    if (price[cur] > price[i]) break;
                    sumDist += dist[i];
                    cnt++;
                }
                ans += price[cur] * sumDist;
                cur += cnt;
                sumDist = 0;
            }
        }

        System.out.println(ans);
    }
}