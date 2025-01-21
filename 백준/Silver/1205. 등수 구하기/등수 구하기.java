import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        if(N == 0) {
            System.out.println(1);
            return;
        }

        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] ranking = new int[P];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ranking[i] = Integer.parseInt(st.nextToken());
        }

        if(N == P && score <= ranking[P-1]) {
            System.out.println(-1);
            return;
        }

        int ans = 1;
        for (int i = 0; i < N; i++) {
            if(score < ranking[i]) ans++;
            else break;
        }

        System.out.println(ans);
    }
}