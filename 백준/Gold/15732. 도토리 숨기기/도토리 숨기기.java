import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static Rule[] rules;

    static class Rule {
        int start;
        int end;
        int interval;

        public Rule(int start, int end, int interval) {
            this.start = start;
            this.end = end;
            this.interval = interval;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 상자의 개수
        K = Integer.parseInt(st.nextToken()); // 규칙의 개수
        int D = Integer.parseInt(st.nextToken()); // 도토리의 개수

        rules = new Rule[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // from
            int B = Integer.parseInt(st.nextToken()); // to
            int C = Integer.parseInt(st.nextToken()); // interval

            rules[i] = new Rule(A, B, C);
        }

        int start = 1;
        int end = N;
        while(start <= end) {
            int mid = (start + end) / 2;

            if(getCnt(mid) < D) start = mid + 1;
            else end = mid - 1;
        }

        System.out.println(start);
    }

    private static Long getCnt(int mid) {
        long cnt = 0;

        for (int i = 0; i < K; i++) {
            Rule rule = rules[i];
            if(rule.start > mid) continue;

            if(rule.end <= mid) {
                cnt += (rule.end - rule.start) / rule.interval + 1;
                continue;
            }

            cnt += (mid - rule.start) == 0 ? 1 : (mid - rule.start) / rule.interval + 1;
        }
        
        return cnt;
    }
}