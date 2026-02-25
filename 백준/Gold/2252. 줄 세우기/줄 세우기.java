import java.io.*;
import java.util.*;

public class Main {
    static int N, M, prev[];
    static ArrayList<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        prev = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            prev[b]++;
        }

        topology();
        System.out.println(sb);
    }

    static void topology() {
        // 1. 진입 차수가 0인 학생 찾기
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (prev[i] == 0) dq.add(i);
        }

        while (!dq.isEmpty()) {
            int cur = dq.poll();
            sb.append(cur).append(" ");

            for (int nxt : graph[cur]) {
                if (--prev[nxt] == 0) dq.add(nxt);
            }
        }
    }
}