import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수열의 크기

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] res = new int[N];
        int len = 1;
        res[0] = A[0];
        for (int i = 1; i < N; i++) {
            if(res[len - 1] < A[i]) {
                res[len] = A[i];
                len++;
            }
            else {
                int start = 0;
                int end = len;
                while(start < end) {
                    int mid = (start + end) / 2;

                    if(res[mid] < A[i]) start = mid + 1;
                    else end = mid;
                }

                res[start] = A[i];
            }
        }

        System.out.println(len);
    }
}