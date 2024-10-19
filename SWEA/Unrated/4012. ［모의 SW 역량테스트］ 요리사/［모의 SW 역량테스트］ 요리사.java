import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, arr[][], res;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine()); // 재료의 개수

            StringTokenizer st;
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            isSelected = new boolean[N];
            res = Integer.MAX_VALUE;
            combination(0, 0);

            System.out.println("#" + test_case + " " + res);
        }
    }

    static void combination(int cnt, int start) {
        if(cnt == N/2) {
            int sum_a = 0, sum_b = 0;
            for (int i = 0; i < N; i++) {
                if(isSelected[i]) { // A 재료 (true인 재료들)
                    for (int j = 0; j < N; j++) {
                        // B재료 이거나 현재 재료이면 패스
                        if(!isSelected[j] || j == i) continue;
                        sum_a += arr[i][j];
                    }
                }
                else { // B 재료 (false인 재료들)
                    for (int j = 0; j < N; j++) {
                        // A재료 이거나 현재 재료이면 패스
                        if(isSelected[j] || j == i) continue;
                        sum_b += arr[i][j];
                    }
                }
            }

            int value = Math.abs(sum_a - sum_b);
            if(res > value) res = value;
            return;
        }

        for (int i = start; i < N; i++) {
            isSelected[i] = true;
            combination(cnt+1, i+1);
            isSelected[i] = false;
        }
    }
}