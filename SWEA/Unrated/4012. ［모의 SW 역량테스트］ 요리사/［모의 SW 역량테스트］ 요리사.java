import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static int N, arr[][], res;
    static ArrayList<Integer> numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine()); // 식재료의 개수

            arr = new int[N][N];
            StringTokenizer st;
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            numbers = new ArrayList<>();
            res = Integer.MAX_VALUE;
            dfs(0, 0);

            System.out.println("#" + test_case + " " + res);
        }
    }

    // idx : 재료 번호, cnt : 재료의 수
    private static void dfs(int idx, int cnt) {
        if(idx >= N) { // 모든 재료에 대해 탐색했다면 종료
            return;
        }

        if(cnt == N/2) { // 재료의 반만큼 선택했다면
            ArrayList<Integer> other = new ArrayList<>();
            for(int i = 0; i < N; i++) { // 나머지 재료들을 other에 담아줌
                if(!numbers.contains(i)) {
                    other.add(i);
                }
            }

            // 맛 계산
            int A = 0, B = 0;
            for(int i = 0; i < N/2; i++) {
                for(int j = i+1; j < N/2; j++) {
                    A += arr[numbers.get(i)][numbers.get(j)] + arr[numbers.get(j)][numbers.get(i)];
                    B += arr[other.get(i)][other.get(j)] + arr[other.get(j)][other.get(i)];
                }
            }

            res = Math.min(res, Math.abs(A-B)); // 맛 차이의 최소값 찾기
            return;
        }

        // 현재 재료를 선택하는 경우
        numbers.add(idx);
        dfs(idx+1, cnt+1);

        // 현재 재료를 선택하지 않는 경우
        numbers.remove(numbers.indexOf(idx));
        dfs(idx+1, cnt);
    }
}
