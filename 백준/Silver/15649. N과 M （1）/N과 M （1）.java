import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 예제 2번에서 [1, 2]와 [2, 1]을 다른 것으로 보았으므로 순열!
public class Main {
    static int n, r, arr[];
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[r];
        visited = new boolean[n+1];
        permutation(0);
    }

    private static void permutation(int cnt) {
        if(cnt == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[cnt] = i;
                permutation(cnt+1);
                visited[i] = false;
            }
        }
    }
}