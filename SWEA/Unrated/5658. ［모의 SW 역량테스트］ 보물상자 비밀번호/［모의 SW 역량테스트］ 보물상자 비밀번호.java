import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

    static int N, K, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 숫자의 개수
            K = Integer.parseInt(st.nextToken()); // K번쨰로 큰 수를 찾을 예정

            String num = br.readLine();
            ArrayList<Character> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(num.charAt(i));
            }

            ArrayList<Integer> val = new ArrayList<>();
            for(int i = 0; i < N/4; i++) {
                for (int j = 0; j < N; j+=N/4) {
                    String str = "";
                    for (int k = j; k < j+(N/4); k++) {
                        str += arr.get(k);
                    }
                    int n = Integer.parseInt(str, 16); // 16진수 -> 10진수
                    if(!val.contains(n)) val.add(n); // 중복 제거
                }
                // 시계 방향 회전
                char tmp = arr.get(N-1);
                arr.remove(N-1);
                arr.add(0, tmp);
            }
            Collections.sort(val, Collections.reverseOrder()); // 내림차순 정렬

            res = val.get(K-1);
            System.out.println("#" + test_case + " " + res);
        }
    }
}