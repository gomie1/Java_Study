import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀의 개수
            int k = Integer.parseInt(st.nextToken()); // 문제의 개수
            int t = Integer.parseInt(st.nextToken()); // 팀의 ID
            int m = Integer.parseInt(st.nextToken()); // 로그 엔트리의 개수

            int[][] score = new int[n+1][k+1];
            int[] submitCnt = new int[n+1];
            int[] submitTime = new int[n+1];
            for (int time = 0; time < m; time++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken()); // 팀 ID
                int j = Integer.parseInt(st.nextToken()); // 문제 번호
                int s = Integer.parseInt(st.nextToken()); // 획득한 점수

                score[id][j] = Math.max(score[id][j], s);
                submitCnt[id]++;
                submitTime[id] = time;
            }

            int[] totalScore = new int[n+1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    totalScore[i] += score[i][j];
                }
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[1] != b[1]) return b[1] - a[1];
                if (a[2] != b[2]) return a[2] - b[2];
                return a[3] - b[3];
            });

            for (int i = 1; i <= n; i++) {
                pq.offer(new int[] {i, totalScore[i], submitCnt[i], submitTime[i]});
            }

            int rank = 1;
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                if (cur[0] == t) {
                    sb.append(rank).append('\n');
                    break;
                }
                rank++;
            }
        }

        System.out.println(sb);
    }
}