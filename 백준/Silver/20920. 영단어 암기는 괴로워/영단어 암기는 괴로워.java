import java.io.*;
import java.util.*;

public class Main {
    static class Voca implements Comparable<Voca> {
        String voca;
        int len;
        int cnt;

        public Voca(String voca, int len, int cnt) {
            this.voca = voca;
            this.len = len;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Voca o) {
            if (this.cnt != o.cnt) return o.cnt - this.cnt; // 횟수가 많은 순 (내림차순)
            if (this.len != o.len) return o.len - this.len; // 길이가 긴 순 (내림차순)
            return this.voca.compareTo(o.voca); // 사전 순서가 빠른 순 (오름차순)
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> count = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String voca = br.readLine();
            if (voca.length() < M) continue;
            count.put(voca, count.getOrDefault(voca, 0) + 1);
        }

        Voca[] vocas = new Voca[count.size()];
        int idx = 0;
        for (String key : count.keySet()) {
            vocas[idx++] = new Voca(key, key.length(), count.get(key));
        }

        Arrays.sort(vocas);

        StringBuilder sb = new StringBuilder();
        for (Voca v : vocas) {
            sb.append(v.voca).append('\n');
        }

        System.out.println(sb);
    }
}