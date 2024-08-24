import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static int N, arr[][], res;
    static boolean[] visited;

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

            visited = new boolean[N];
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

        if(cnt == N/2) { // 재료의 반만큼 선택했다면 맛 계산
            int A = 0, B = 0;
            for(int i = 0; i < N; i++) {
                if(visited[i]) { // A 재료들
                    for(int j = i+1; j < N; j++) {
                        if(visited[j]) {
                            A += arr[i][j] + arr[j][i];
                        }
                    }
                }
                else { // B 재료들
                    for(int j = i+1; j < N; j++) {
                        if(!visited[j]) {
                            B += arr[i][j] + arr[j][i];
                        }
                    }
                }
            }

            res = Math.min(res, Math.abs(A-B)); // 맛 차이의 최소값 찾기
            return;
        }

        // 현재 재료를 선택하는 경우
        visited[idx] = true;
        dfs(idx+1, cnt+1);

        // 현재 재료를 선택하지 않는 경우
        visited[idx] = false;
        dfs(idx+1, cnt);
    }
}
