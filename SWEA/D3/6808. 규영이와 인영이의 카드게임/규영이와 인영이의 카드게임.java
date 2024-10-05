import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int card[], other[], isSelected[], win, lose;
    private static boolean[] cardCheck, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 규영이의 카드 입력받기
            card = new int[9];
            cardCheck = new boolean[19];
            for (int i = 0; i < 9; i++) {
                card[i] = Integer.parseInt(st.nextToken());
                cardCheck[card[i]] = true;
            }

            // 1 ~ 18까지의 숫자카드 중 규영이에게 없는 숫자카드를 인영이 카드로 주기
            other = new int[9];
            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if(!cardCheck[i]) {
                    other[idx++] = i;
                }
            }

            // 카드 순서가 승패에 영향을 미치므로 인영이의 카드를 순열로 섞기
            visited = new boolean[9];
            isSelected = new int[9];
            win = 0;
            lose = 0;
            permutation(0);

            System.out.println("#" + test_case + " " + win + " " + lose);
        }
    }

    private static void permutation(int idx) {
        if(idx == 9) {
            int gy = 0; // 규영이의 점수
            int iy = 0; // 인영이의 점수
            for (int i = 0; i < 9; i++) {
                if(card[i] > other[isSelected[i]]) { // 규영이가 이기는 경우
                    gy += card[i] + other[isSelected[i]];
                }
                else if(card[i] < other[isSelected[i]]) { // 인영이가 이기는 경우
                    iy += card[i] + other[isSelected[i]];
                }
            }

            if(gy > iy) win++;
            else if(gy < iy) lose++;

            return;
        }

        for (int i = 0; i < 9; i++) {
            if(!visited[i]) {
                visited[i] = true;
                isSelected[idx] = i;
                permutation(idx+1);
                visited[i] = false;
            }
        }
    }
}