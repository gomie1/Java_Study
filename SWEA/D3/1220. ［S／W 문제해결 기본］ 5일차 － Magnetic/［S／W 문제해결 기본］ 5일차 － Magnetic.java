import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= 10; test_case++) {
            int len = Integer.parseInt(br.readLine());

            StringTokenizer st;
            int[][] arr = new int[100][100]; // 1: N극, 2: S극
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int res = 0;
            for (int j = 0; j < 100; j++) {
                boolean flag = false;
                for (int i = 0; i < 100; i++) {
                    if(arr[i][j] == 1) { //현재 자성체가 N극 이라면
                        flag = true; // N극 자성체 방문 처리
                    }
                    else if(arr[i][j] == 2) { // 현재 자성체가 S극일 때
                        if(flag) {
                            res++; // N극 자성체를 만난적이 있다면 교착상태가 됨
                            flag = false; // 새로운 교착상태가 있을 수 있으므로 flag 초기화
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + res);
        }
    }
}