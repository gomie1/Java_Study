import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int D, W, K, copyArr[][], res, selected[], arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken()); // 보호 필름의 두께
            W = Integer.parseInt(st.nextToken()); // 가로 크기
            K = Integer.parseInt(st.nextToken()); // 합격 기준

            selected = new int[D];
            arr = new int[D][W];
            copyArr = new int[D][W];
            for (int i = 0; i < D; i++) { // 0: A, 1: B
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    copyArr[i][j] = arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            res = Integer.MAX_VALUE;
            subset(0);
            System.out.println("#" + test_case + " " + res);
        }
    }

    private static void subset(int depth){
        if(depth == D){
            dfs(0, 0);

            // dfs를 돌고나면 copyArr이 바뀌어 있으므로 다시 초기화
            for (int i = 0; i < D; i++) {
                for (int j = 0; j < W; j++) {
                    copyArr[i][j] = arr[i][j];
                }
            }
            return;
        }

        selected[depth] = 0;
        subset(depth+1);

        selected[depth] = 1; // 약물을 주입할 row 선정
        subset(depth+1);
    }

    // selected = {0, 1, 1, 0, 0, 0, 1, 1}
    private static void dfs(int idx, int cnt) {
        if(idx == D) {
            if(isPass())
                if(res > cnt) res = cnt;
            return;
        }

        if(selected[idx] == 1) {
            // 현재 줄에 A 약물을 투입하는 경우
            Arrays.fill(copyArr[idx], 0);
            dfs(idx+1, cnt+1);

            // 현재 줄에 B 약물을 투입하는 경우
            Arrays.fill(copyArr[idx], 1);
            dfs(idx+1, cnt+1);
        }
        else {
            // 현재 줄에 약물을 투입하지 않는 경우
            dfs(idx+1, cnt);
        }
    }

    // 성능검사 통과 여부 확인
    private static boolean isPass() {
        int cnt, flag;

        for (int j = 0; j < W; j++) {
            flag = copyArr[0][j];
            cnt = 1;
            for (int i = 1; i < D; i++) {
                if (copyArr[i][j] == flag) {
                    cnt++;
                }
                else {
                    flag = copyArr[i][j];
                    cnt = 1;
                }

                if(cnt >= K) break;
            }

            if(cnt < K) return false;
        }

        return true;
    }
}