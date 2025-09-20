import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer[] score = new Integer[N];
        int val = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int sum = 0;

            sum += Integer.parseInt(st.nextToken()) * 5;
            sum += Integer.parseInt(st.nextToken()) * 3;
            sum += Integer.parseInt(st.nextToken());

            score[idx-1] = sum;
            if (idx == K) val = sum;
        }

        Arrays.sort(score, Collections.reverseOrder());
        for (int i = 0; i <= N; i++) {
            if (val == score[i]) {
                System.out.println(i+1);
                return;
            }
        }
    }
}