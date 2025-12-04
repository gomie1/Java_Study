import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> cnt = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long key = Long.parseLong(br.readLine());
            cnt.put(key, cnt.getOrDefault(key, 0) + 1);
        }

        long ans = Long.MAX_VALUE;
        int val = 0;
        for (long key : cnt.keySet()) {
            if (val < cnt.get(key)) {
                ans = key;
                val = cnt.get(key);
            } else if (val == cnt.get(key) && key < ans) ans = key;
        }

        System.out.println(ans);
    }
}