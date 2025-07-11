import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] monster = new String[N+1];
        HashMap<String, Integer> nameToIdx = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            monster[i] = name;
            nameToIdx.put(name, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String question = br.readLine();
            if (question.charAt(0) - '0' >= 1 && question.charAt(0) - '0' <= 9) sb.append(monster[Integer.parseInt(question)]).append('\n');
            else sb.append(nameToIdx.get(question)).append('\n');
        }

        System.out.print(sb);
    }
}