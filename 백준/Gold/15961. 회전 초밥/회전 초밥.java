import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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

        // 초밥 번호 별 먹은 개수 check
        int[] eaten = new int[d+1];
        eaten[c]++; // 쿠폰 초밥은 항상 먹음

        // 0번부터 k개의 초밥을 먹은 경우
        int cnt = 1;
        for (int i = 0; i < k; i++) {
            if(eaten[sushi[i]] == 0) cnt++;
            eaten[sushi[i]]++;
        }

        int res = cnt;
        int end = k-1;
        for (int start = 0; start < N; start++) {
            // 시작 초밥 제거
            eaten[sushi[start]]--;
            if(eaten[sushi[start]] == 0) cnt--;

            // 끝 초밥 추가
            end = (end + 1) % N;
            if(eaten[sushi[end]] == 0) cnt++;
            eaten[sushi[end]]++;

            res = Math.max(res, cnt);
        }

        System.out.println(res);
    }
}