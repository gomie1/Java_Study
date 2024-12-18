import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 전체 용액의 수

        // 용액들의 특성 값 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // N == 3인 경우, 바로 결과 출력
        if (N == 3) {
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
            return;
        }
        
        long min = Long.MAX_VALUE;
        int[] res = new int[3];
        for (int i = 0; i < N-2; i++) {
            int start = i;
            int mid = i + 1;
            int end = N - 1;

            while(mid < end) {
                long sum = (long) arr[start] + arr[mid] + arr[end];
                if(min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    res[0] = arr[start];
                    res[1] = arr[mid];
                    res[2] = arr[end];
                }

                if(sum == 0) { // 0보다 작은 값을 없으므로 바로 종료
                    break;
                }
                else if(sum > 0) {
                    end--;
                }
                else {
                    mid++;
                }
            }
        }

        Arrays.sort(res);
        System.out.println(res[0] + " " + res[1] + " " + res[2]);
    }
}