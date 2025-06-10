import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[2000001];
        for (int i = 0; i < N; i++) {
            visited[Integer.parseInt(br.readLine()) + 1000000] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 2000000; i++) {
            if (visited[i]) sb.append(i - 1000000).append('\n');
        }

        System.out.print(sb);
    }
}