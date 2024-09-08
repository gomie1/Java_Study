import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int N, arr[], select[];
    static long res;
    static boolean[] visited, chosen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine()); // 무게 추의 개수

            // 각 추의 무게 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            res = 0;
            visited = new boolean[N];
            select = new int[N];
            permutation(0);
            System.out.println("#" + test_case + " " + res);
        }
    }

    private static void permutation(int idx) {
        if(idx == N) {
            chosen = new boolean[N]; // left, right를 구분하기 위한 배역
            powerSet(0, 0, 0); // 부분집합
            // System.out.println("select = " + Arrays.toString(select));
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                select[idx] = arr[i];
                permutation(idx+1);
                visited[i] = false;
            }
        }
    }

    // 오른쪽 무게의 총 합이 왼쪽 무게의 총 합보다 커져서는 안됨
    private static void powerSet(int idx, int left, int right) {
        if(left < right) return; // 가지치기

        if(idx == N) {
            res++;
            return;
        }

        // 현재 추를 왼쪽 저울에 올리는 경우
        chosen[idx] = false;
        powerSet(idx + 1, left+select[idx], right);
		
        // 현재 추를 오른쪽 저울에 올리는 경우
        chosen[idx] = true;
        powerSet(idx + 1, left, right+select[idx]);
    }
}
