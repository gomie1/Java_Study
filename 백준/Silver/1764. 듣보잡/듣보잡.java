import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> name = new HashSet<>();
        for (int i = 0; i < N; i++) {
            name.add(br.readLine());
        }

        List<String> arr = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (name.contains(input)) arr.add(input);
        }
        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        sb.append(arr.size()).append('\n');
        for (String n : arr) sb.append(n).append('\n');

        System.out.print(sb);
    }
}