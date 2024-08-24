import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 합을 구해야하는 횟수

        // N개의 숫자 입력 받기
        int[] arr = new int[N];
        int[] pSum = new int[N+1]; // 누적합 배열
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            /* 누적합 구하기 */
            if(i == 0) {
                continue;
            }

            if(i == 1) {
                pSum[i] = arr[i-1];
            }
            else {
                pSum[i] = pSum[i-1] + arr[i-1];
            }
        }
        pSum[N] = pSum[N-1] + arr[N-1];

        for(int a = 0; a < M; a++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(pSum[j] - pSum[i-1]);
        }
    }
}
