import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, operator[], num[], max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine()); // 숫자의 개수

            // 각 연산자의 개수 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            operator = new int[4];
            for (int i = 0; i < 4; i++) {
                operator[i] = Integer.parseInt(st.nextToken());
            }

            // 사용할 숫자들 입력 받기
            st = new StringTokenizer(br.readLine());
            num = new int[N];
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            dfs(1, num[0]);
            System.out.println("#" + test_case + " " + (max - min));
        }
    }
    
    static void dfs(int cnt, int ans) {
        if(cnt == N) {
            if(max < ans) max = ans;
            if(min > ans) min = ans;

            return;
        }

        // 현재 연산에 "+"를 사용하는 경우
        if(operator[0] > 0) {
            operator[0] -= 1; // "+" 연산자 1 감소
            dfs(cnt+1, ans+num[cnt]);
            operator[0] += 1; // "+" 연산자 수 원상복구
        }

        // 현재 연산에 "-"를 사용하는 경우
        if(operator[1] > 0) {
            operator[1] -= 1; // "-" 연산자 1 감소
            dfs(cnt+1, ans-num[cnt]);
            operator[1] += 1; // "-" 연산자 수 원상복구
        }

        // 현재 연산에 "*"를 사용하는 경우
        if(operator[2] > 0) {
            operator[2] -= 1; // "*" 연산자 1 감소
            dfs(cnt+1, ans*num[cnt]);
            operator[2] += 1; // "*" 연산자 수 원상복구
        }

        // 현재 연산에 "/"를 사용하는 경우
        if(operator[3] > 0) {
            operator[3] -= 1; // "/" 연산자 1 감소
            dfs(cnt+1, ans/num[cnt]);
            operator[3] += 1; // "/" 연산자 수 원상복구
        }
    }
}