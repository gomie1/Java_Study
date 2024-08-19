import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine()); // 정사각형 테이블의 한 변의 길이

            // 테이블의 초기 모습 입력 받기
            StringTokenizer st;
            int[][] table = new int[N][N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 1 : N극 성질, 2 : S극 성질
            int ans = 0;
            for(int i = 0; i < 100; i++) {
                int prev = 0;
                for(int j = 0; j < 100; j++) {
                    // 각 열마다 체크하기 위해 [j][i]로 설정
                    if(table[j][i] == 1) { // 현재 위치의 값이 1이면
                        prev = 1; // prev를 1로 표시
                    } // 현재 위치 값이 2이면 N극 쪽으로 떨어지기 때문에 고려 X

                    // 현재 위치 이전에 같은 열에 1번이 있는 상태에서 2번을 만났다면 교착상태
                    if(prev == 1 && table[j][i] == 2) {
                        ans += 1;
                        prev = 0;
                    }
                }
            }

            System.out.println("#" + test_case + " " + ans);
        }
    }
}
