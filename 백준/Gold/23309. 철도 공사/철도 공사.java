import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] prev = new int[1000001];
        int[] next = new int[1000001];
        prev[num[0]] = num[N-1];
        next[num[0]] = num[1];
        prev[num[N-1]] = num[N-2];
        next[num[N-1]] = num[0];
        for (int i = 1; i < N-1; i++) {
            prev[num[i]] = num[i-1];
            next[num[i]] = num[i+1];
        }

        StringBuilder sb = new StringBuilder();
        int delete = 0;
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int i = Integer.parseInt(st.nextToken());
            int j = 0;
            if (cmd.charAt(0) == 'B') j = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case "BN":
                    sb.append(next[i]).append('\n');
                    prev[next[i]] = j;
                    next[j] = next[i];
                    prev[j] = i;
                    next[i] = j;
                    break;
                case "BP":
                    sb.append(prev[i]).append('\n');
                    prev[j] = prev[i];
                    next[prev[i]] = j;
                    prev[i] = j;
                    next[j] = i;
                    break;
                case "CN":
                    sb.append(next[i]).append('\n');
                    delete = next[i];
                    next[i] = next[delete];
                    prev[next[delete]] = i;
                    next[delete] = 0;
                    prev[delete] = 0;
                    break;
                case "CP":
                    sb.append(prev[i]).append('\n');
                    delete = prev[i];
                    prev[i] = prev[delete];
                    next[prev[delete]] = i;
                    prev[delete] = 0;
                    next[delete] = 0;
                    break;
            }
        }

        System.out.println(sb);
    }
}