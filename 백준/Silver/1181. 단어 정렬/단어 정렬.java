import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>(set);
        list.sort((a, b) -> {
            if (a.length() != b.length()) return a.length() - b.length();
            else return a.compareTo(b);
        });

        for (String str : list) sb.append(str + "\n");
        System.out.println(sb);
    }
}