import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] fruits = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int ans = 0;
        int[] types = new int[10];
        int cnt = 0;
        for (int right = 0; right < N; right++) {
            if (types[fruits[right]] == 0) cnt++;
            types[fruits[right]]++;

            while (cnt > 2) {
                types[fruits[left]]--;
                if (types[fruits[left]] == 0) cnt--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        System.out.println(ans);
    }
}