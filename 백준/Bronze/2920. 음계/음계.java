import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cur = Integer.parseInt(st.nextToken());
        int ans = 0;
        for (int i = 0; i < 7; i++) {
            int nxt = Integer.parseInt(st.nextToken());

            if (cur < nxt) ans++;
            else ans--;

            cur = nxt;
        }

        if (ans == 7) System.out.println("ascending");
        else if (ans == -7) System.out.println("descending");
        else System.out.println("mixed");
    }
}