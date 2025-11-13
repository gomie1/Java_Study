import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] money = new int[N];
        int low = 0; // low: 모든 날의 지출을 감당할 수 있어야 하므로 하루 지출 중 가장 큰 금액으로 설정
        int high = 0; // high: K가 지출의 총합과 같으면 인출 횟수는 무조건 1번 이므로 총합보다 더 클 필요는 없음
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            low = Math.max(low, money[i]);
            high += money[i];
        }
        
        while (low < high) {
            int K = (low + high) / 2;

            int cur = K;
            int cnt = 1;
            for (int i = 0; i < N; i++) {
                if (money[i] <= cur) cur -= money[i];
                else {
                    cur = K - money[i];
                    cnt++;
                }
            }

            if (cnt <= M) high = K - 1;
            else low = K + 1;
        }

        System.out.println(low);
    }
}