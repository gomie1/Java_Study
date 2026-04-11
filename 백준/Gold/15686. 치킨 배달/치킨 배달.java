import java.io.*;
import java.util.*;

public class Main {
    static int N, M, answer;
    static ArrayList<int[]> home, chicken;
    static boolean[] selected;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        home = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken()); // 0: 빈 칸, 1: 집, 2: 치킨집

                if (val == 1) home.add(new int[] {i, j});
                else if (val == 2) chicken.add(new int[] {i, j});
            }
        }

        // 1. M개의 치킨집 고르기
        answer = Integer.MAX_VALUE;
        selected = new boolean[chicken.size()];
        combination(0, 0);

        System.out.println(answer);
    }

    static void combination(int start, int cnt) {
        if (cnt == M) {
            int[] dist = new int[home.size()];
            Arrays.fill(dist, Integer.MAX_VALUE);

            // 2. 고른 치킨집들을 기준으로 각 집의 치킨 거리 구하기
            for (int i = 0; i < chicken.size(); i++) {
                if (!selected[i]) continue;

                int cx = chicken.get(i)[0];
                int cy = chicken.get(i)[1];

                for (int j = 0; j < home.size(); j++) {
                    dist[j] = Math.min(dist[j], Math.abs(cx - home.get(j)[0]) + Math.abs(cy - home.get(j)[1]));
                }
            }

            // 3. 도시의 치킨 거리 최소값 갱신
            int sum = 0;
            for (int d : dist) sum += d;
            answer = Math.min(answer, sum);
        }

        for (int i = start; i < chicken.size(); i++) {
            selected[i] = true;
            combination(i+1, cnt+1);
            selected[i] = false;
        }
    }
}