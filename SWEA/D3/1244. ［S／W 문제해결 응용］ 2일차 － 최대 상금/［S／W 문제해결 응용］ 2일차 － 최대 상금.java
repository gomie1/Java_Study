import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int card[], n, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 숫자판 입력받기
            char[] input = st.nextToken().toCharArray();
            card = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                card[i] = input[i] - '0'; // char to int
            }

            n = Integer.parseInt(st.nextToken()); // 교환 횟수
            // 가지치기 (교환횟수가 숫자판 개수만큼만 돌아도 모든 숫자 교환 가능)
            if(n > card.length) n = card.length;

            res = 0;
            dfs(0, 0);
            System.out.println("#" + test_case + " " + res);
        }
    }

    private static void dfs(int cnt, int start) {
        if(cnt == n) { // 교환횟수만큼 반복했다면
            int val = 0;
            for (int i = 0; i < card.length; i++) { // 현재 카드 배열을 숫자로 변환하고
                val +=(Math.pow(10, i) * card[card.length - i-1]);
            }
            res = Math.max(res, val); // 최대값 산출 후 종료
            return;
        }

        for (int i = start; i < card.length; i++) {
            for(int j = i+1; j < card.length; j++) {
                swap(i, j);
                dfs(cnt+1, i);
                swap(i, j);
            }
        }
    }

    private static void swap(int a, int b) {
        int tmp = card[a];
        card[a] = card[b];
        card[b] = tmp;
    }
}