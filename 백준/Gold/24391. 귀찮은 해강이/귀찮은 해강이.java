import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 강의의 개수
        int M = Integer.parseInt(st.nextToken()); // 건물의 쌍의 개수

        parents = new int[N+1];
        Arrays.fill(parents, -1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int ans = 0;
        st = new StringTokenizer(br.readLine());
        int cur = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N-1; i++) {
            int nxt = Integer.parseInt(st.nextToken());
            
            if(findRoot(cur) != findRoot(nxt)) ans++;
            cur = nxt;
        }

        System.out.println(ans);
    }

    private static int findRoot(int a) {
        if(parents[a] < 0) return a;
        return parents[a] = findRoot(parents[a]);
    }

    private static void union(int a, int b) {
        int aRoot = findRoot(a);
        int bRoot = findRoot(b);

        if(aRoot == bRoot) return;
        parents[bRoot] = aRoot;
    }
}