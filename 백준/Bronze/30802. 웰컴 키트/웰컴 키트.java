import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6]; // 사이즈별 신청자의 수
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); // 티셔츠 묶음 수
        int P = Integer.parseInt(st.nextToken()); // 펜 묶음 수

        StringBuilder sb = new StringBuilder();
        int ans = 0;
        for (int i = 0; i < 6; i++) {
            if (arr[i] == 0) continue;
            else if (arr[i] <= T) ans++;
            else {
                if (arr[i] % T == 0) ans += (arr[i] / T);
                else ans += (arr[i] / T) + 1;
            }
        }

        sb.append(ans).append("\n");
        sb.append(N/P).append(" ").append(N%P);

        System.out.println(sb);
    }
}