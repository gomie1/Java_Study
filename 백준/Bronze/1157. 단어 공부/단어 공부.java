import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.toUpperCase();

        char[] alpha = new char[26];
        char val = 'A';
        for (int i = 0; i < 26; i++) {
            alpha[i] = val++;
        }

        int[] cnt = new int[26];
        for (char c : str.toCharArray()) {
            cnt[c - 'A']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o2[1] - o1[1];
        });
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) pq.offer(new int[] {i, cnt[i]});
        }

        int[] max = pq.poll();
        boolean flag = false;
        if (!pq.isEmpty()) {
            int[] nxt = pq.poll();
            if (nxt[1] == max[1]) flag = true;
        }

        if (flag) System.out.println('?');
        else System.out.println(alpha[max[0]]);
    }
}