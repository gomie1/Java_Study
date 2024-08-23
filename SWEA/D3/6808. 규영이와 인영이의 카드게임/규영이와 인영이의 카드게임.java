import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int win, lose;
    static int[] gyu_card, in_card, numbers;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            gyu_card = new int[9]; // 규영이가 받은 9장의 카드
            in_card = new int[9]; // 인영이가 받은 9장의 카드
            isSelected = new boolean[19];

            // 규영이의 카드를 입력 받고, 각 카드 번호는 선택 처리
            for(int i = 0; i < 9; i++) {
                int value = Integer.parseInt(st.nextToken());
                gyu_card[i] = value;
                isSelected[value] = true;
            }

            // 남은 카드들을 인영이에게 줌
            int cnt = 0;
            for(int i = 1; i <= 18; i++) {
                if(!isSelected[i]) {
                    in_card[cnt] = i;
                    cnt++;
                }
            }

            win = 0;
            lose = 0;
            isSelected = new boolean[9];
            numbers = new int[9];
            permutation(0);
            System.out.println("#" + test_case + " " + win + " " + lose);
        }
    }

    private static void permutation(int cnt) {
        if(cnt == 9) {
            int gyu_win = 0, in_win = 0;
            // 9 라운드에 걸쳐 게임 진행
            for(int i = 0; i < 9; i++) {
                if(gyu_card[i] > in_card[numbers[i]]) {
                    gyu_win += (gyu_card[i] + in_card[numbers[i]]);
                }
                else if(gyu_card[i] < in_card[numbers[i]]) {
                    in_win += (gyu_card[i] + in_card[numbers[i]]);
                }
            }

            if(gyu_win > in_win) { // 규영이가 이긴 경우
                win++;
            }
            else if(gyu_win < in_win) { // 규영이가 지는 경우
                lose++;
            }

            return;
        }

        // 순서가 유의미하기 때문에 순열을 통한 카드 선택
        for(int i = 0; i < 9; i++) {
            if(!isSelected[i]) {
                isSelected[i] = true;
                numbers[cnt] = i;
                permutation(cnt+1);
                isSelected[i] = false;
            }
        }
    }
}