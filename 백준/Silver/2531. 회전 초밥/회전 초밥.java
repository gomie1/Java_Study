import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 접시의 수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] chosen = new int[d+1];
        int cnt = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            if (chosen[sushi[i]] == 0) {
                cnt++;
            }
            chosen[sushi[i]]++;
        }

        if (chosen[c] == 0) max = Math.max(max, cnt+1);
        else max = Math.max(max, cnt);

        int start = 0;
        int end = k;
        while (start < N) {
            // 1. 맨 앞 초밥 빼기
            chosen[sushi[start]]--;
            if (chosen[sushi[start]] == 0) cnt -= 1;
            start++;

            // 2. 다음 초밥 넣기
            chosen[sushi[end]]++;
            if (chosen[sushi[end]] == 1) cnt += 1;
            if (++end == N) end = 0;

            // 3. 최댓값 갱신
            if (chosen[c] == 0) max = Math.max(max, cnt+1);
            else max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}