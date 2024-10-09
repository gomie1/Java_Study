import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 합을 구해야하는 횟수

        // 누적합 저장
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        arr[0] = 0;
        for(int i = 1; i <= N; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int a = 0; a < M; a++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(arr[j] - arr[i-1]);
        }
    }
}