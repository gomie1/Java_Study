import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 커넥티드 카 개수
        int S = Integer.parseInt(st.nextToken()); // 처음 연결할 커넥티드 카 번호

        // 초기 위치
        int[] x = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        // 연료량
        int[] h = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        boolean[] isConnected = new boolean[N+1];
        isConnected[S] = true;

        int left = S;
        int right = S;
        while (!q.isEmpty()) {
            int cur = q.poll();

            // 현재 차가 전파를 보낼 수 있는 최소, 최대 좌표
            int minPos = x[cur] - h[cur];
            int maxPos = x[cur] + h[cur];

            // 1. 왼쪽 경계선 확장
            while (left - 1 > 0 && x[left - 1] >= minPos) {
                left--;
                if (!isConnected[left]) {
                    isConnected[left] = true;
                    q.add(left);
                }
            }

            // 2. 오르쪽 경계선 확장
            while (right + 1 <= N && x[right + 1] <= maxPos) {
                right++;
                if (!isConnected[right]) {
                    isConnected[right] = true;
                    q.add(right);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (isConnected[i]) sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}