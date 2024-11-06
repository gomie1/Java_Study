import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, population[], res;
    static ArrayList<Integer>[] graph;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        population = new int[N+1];
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                int v = Integer.parseInt(st.nextToken());
                graph[i].add(v);
            }
        }

        isSelected = new boolean[N+1];
        res = Integer.MAX_VALUE;
        dfs(1, 0, 0);
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    private static void dfs(int idx, int Asum, int Bsum) {
        if(idx == N+1) {
            if(isConnect(true) && isConnect(false)) {
                if(res > Math.abs(Asum - Bsum)) res = Math.abs(Asum - Bsum);
            }
            return;
        }

        // 현재 구역을 선택하지 않는 경우
        dfs(idx+1, Asum, Bsum+population[idx]);

        // 현재 구역을 선택한 경우
        isSelected[idx] = true;
        dfs(idx+1, Asum+population[idx], Bsum);
        isSelected[idx] = false;
    }

    private static boolean isConnect(boolean val) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if(isSelected[i] == val) {
                arr.add(i);
            }
        }

        if(arr.size() == 0 || arr.size() == N) return false;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        q.offer(arr.get(0));
        visited[arr.get(0)] = true;

        int cnt = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int num : graph[cur]) {
                if(!visited[num] && isSelected[num] == val) {
                    visited[num] = true;
                    q.offer(num);
                }
            }

            cnt++;
        }

        if(cnt == arr.size()) return true;
        else return false;
    }
}