import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 1. 두 배열 A, B를 입력 받고, 각각의 부배열 합들을 계산
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> aSum = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                aSum.add(sum);
            }
        }

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> bSum = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                bSum.add(sum);
            }
        }

        // 2. A, B의 부배열 리스트 정렬
        Collections.sort(aSum);
        Collections.sort(bSum);

        // 3. 투 포인터를 활용해 T가 되는 조합 찾기
        long answer = 0;
        int ptr1 = 0;
        int ptr2 = bSum.size() - 1;
        while (ptr1 < aSum.size() && ptr2 >= 0) {
            int sum = aSum.get(ptr1) + bSum.get(ptr2);

            if (sum == T) {
                // ex. aSum = {1, 1, 3, 4}, bSum = {1, 2, 4, 4} -> 5 만들기 예시
                // 1+4의 경우가 aSum[0]+bSum[3], aSum[0]+bSum[2], aSum[1]+bSum[3], aSum[1]+bSum[2]으로 4가지가 존재
                // 전체 경우의 수 = aSum에서 연속된 1의 개수 * bSum에서 연속된 4의 개수 = 2 * 2 = 4
                int a = aSum.get(ptr1);
                int b = bSum.get(ptr2);
                long aCnt = 0;
                long bCnt = 0;

                while (ptr1 < aSum.size() && aSum.get(ptr1) == a) {
                    aCnt++;
                    ptr1++;
                }

                while (ptr2 >= 0 && bSum.get(ptr2) == b) {
                    bCnt++;
                    ptr2--;
                }

                answer += aCnt * bCnt;
            }
            else if (sum < T) ptr1++;
            else ptr2--;
        }

        System.out.println(answer);
    }
}