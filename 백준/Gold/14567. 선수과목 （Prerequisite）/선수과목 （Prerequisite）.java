import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, preCnt[], res[];
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 과목의 수
        M = Integer.parseInt(st.nextToken()); // 선수 조건의 수

        preCnt = new int[N+1]; // 각 과목 별 선수 과목의 수를 저장할 배열
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);
            preCnt[B]++;
        }

        res = new int[N+1];
        bfs();
        for(int i = 1; i <= N; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>(); // {subject, time}
        // 선수과목이 없는(0인) 과목들을 큐에 삽입
        for (int i = 1; i <= N; i++) {
            if(preCnt[i] == 0) q.offer(new int[] {i, 1});
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            res[cur[0]] = cur[1];

            for(int subject : graph[cur[0]]) {
                preCnt[subject]--;
                if(preCnt[subject] == 0) q.offer(new int[] {subject, cur[1]+1});
            }
        }
    }
}