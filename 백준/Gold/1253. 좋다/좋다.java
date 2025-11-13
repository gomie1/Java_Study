import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 1. A 배열 정렬
        Arrays.sort(A);

        // 2. 목표 숫자 선택
        int goodCnt = 0;
        for (int k = 0; k < N; k++) {
            int target = A[k];
            int left = 0;
            int right = N - 1;

            // 3. 투 포인터로 target을 만들 수 있는지 탐색
            while (left < right) {
                int sum = A[left] + A[right];

                if (sum == target) {
                    if (left != k && right != k) {
                        goodCnt++;
                        break; // 좋은 수를 찾았으므로 탐색 종료 -> 다음 숫자로 타겟 변경
                    }
                    // left/right 포인터가 자기 자신(타겟)을 가리키면 이동
                    else if (left == k) left++;
                    else if (right == k) right--;
                }
                else if (sum < target) left++; // 합이 작으므로 left를 증가시켜 합을 키움
                else right--; // 합이 크므로 right를 감소시켜 합을 줄임
            }
        }

        System.out.println(goodCnt);
    }
}