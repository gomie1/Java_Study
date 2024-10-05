import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int tc = Integer.parseInt(br.readLine()); // 테스트 케이스의 번호
            StringTokenizer st;

            // 사다리 입력 받기
            int[][] ladder = new int[100][100];
            int pos = -1;
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                    if(ladder[i][j] == 2) pos = j;
                }
            }

            int x = 99, y = pos; // 초기 위치 설정
            int res = 0;
            while(true) {
                if(x == 0) {
                    res = y;
                    break;
                }

                ladder[x][y] = 0; // 현재 위치 방문처리를 위해 0으로 설정

                if(y-1 >= 0 && ladder[x][y-1] == 1) { // 왼쪽에 길이 있는 경우
                    y -= 1;
                }
                else if(y+1 < 100 && ladder[x][y+1] == 1) { // 오른쪽에 길이 있는 경우
                    y += 1;
                }
                else { // 좌/우에 모두 길이 없다면 위로 올라가기
                    x -= 1;
                }
            }

            System.out.println("#" + tc + " " + res);
        }
    }
}