import java.io.*;
import java.util.*;

public class Main {
    static class Word implements Comparable<Word> {
        String str;
        int len;
        int cnt;

        Word(String str, int len, int cnt) {
            this.str = str;
            this.len = len;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Word o) {
            if (this.cnt != o.cnt) return o.cnt - this.cnt;
            if (this.len != o.len) return o.len - this.len;
            return this.str.compareTo(o.str);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> words = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.length() < M) continue;
            words.put(str, words.getOrDefault(str, 1) + 1);
        }

        PriorityQueue<Word> pq = new PriorityQueue<>();
        for (String key : words.keySet()) {
            pq.offer(new Word(key, key.length(), words.get(key)));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll().str).append('\n');
        }
        System.out.println(sb);
    }
}