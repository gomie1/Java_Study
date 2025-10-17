import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> keyword = new HashSet<>();
        for (int i = 0; i < N; i++) {
            keyword.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(",");
            for (String s : input) keyword.remove(s);
            sb.append(keyword.size()).append('\n');
        }

        System.out.println(sb);
    }
}