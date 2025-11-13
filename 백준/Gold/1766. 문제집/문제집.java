import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1. 각 문제들의 조건을 그래프화 및 과목별 선수되어야할 과목 수 카운팅
        int[] preCnt = new int[N+1];
        ArrayList<Integer>[] problems = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            problems[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            problems[a].add(b); // a를 풀면 b를 풀 수 있음
            preCnt[b]++;
        }

        // 2. 지금 바로 풀 수 있는 문제들부터 시작
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (preCnt[i] == 0) pq.add(i);
        }

        // 3. 그래프 탐색
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(" ");

            for (int nxt : problems[cur]) {
                preCnt[nxt]--;
                if (preCnt[nxt] == 0) pq.add(nxt);
            }
        }

        System.out.println(sb);
    }
}