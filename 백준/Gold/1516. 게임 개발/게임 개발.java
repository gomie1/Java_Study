import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] time;
    static int[] preCnt;
    static int[] res;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 건물 종류의 수
        time = new int[N+1]; // 각 건물을 짓는데 걸리는 시간을 담아줄 배열
        preCnt = new int[N+1]; // 각 건물 별 먼저 지어야 할 건물의 수

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int idx = 1;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int flag = 0;

            while (true) {
                int value = Integer.parseInt(st.nextToken());
                if (value == -1) break;

                if (flag == 0) {
                    time[idx] = value;
                } else {
                    graph[value].add(idx);
                    preCnt[idx]++;
                }

                flag++;
            }
            idx++;
        }

        res = new int[N+1];
        Build();

        for (int i = 1; i <= N; i++) {
            System.out.println(res[i]);
        }
    }

    // time = {0, 10, 20, 14, 4, 3}
    // preCnt = {0, 0, 1, 1, 2, 1}
    private static void Build() {
        Queue<Integer> q = new LinkedList<>();

        // 큐에 먼저 지어져야하는 건물이 없는 건물만 삽입
        for (int i = 1; i <= N; i++) {
            if(preCnt[i] == 0) {
                q.offer(i); // {1, 10}
                res[i] = time[i];
            }
        }

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int b : graph[cur]) {
                res[b] = Math.max(res[b], res[cur] + time[b]);
                preCnt[b]--;
                if(preCnt[b] == 0) q.offer(b);
            }
        }
    }
}

// graph = [[],
//          [2, 3, 4],
//          [],
//          [4, 5],
//          [],
//          []]