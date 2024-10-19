import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 0; test_case < 10; test_case++) {
            int tc = Integer.parseInt(br.readLine()); // 테스트 케이스의 번호

            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> num = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                num.add(Integer.parseInt(st.nextToken()));
            }

            int cnt = 1;
            while(true) {
                int val = num.get(0);

                num.remove(0);
                val -= cnt;
                if(val <= 0) {
                    num.add(0);
                    break;
                }
                num.add(val);

                cnt++;
                if(cnt > 5) cnt = 1;
            }

            System.out.print("#" + tc + " ");
            for (int i = 0; i < 8; i++) {
                System.out.print(num.get(i) + " ");
            }
            System.out.println();
        }
    }
}