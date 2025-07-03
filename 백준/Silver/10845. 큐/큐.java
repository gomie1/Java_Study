import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            int val = 0;
            if (input.startsWith("push")) {
                val = Integer.parseInt(input.substring(5));
                input = input.substring(0, 4);
            }

            switch (input) {
                case "push":
                    q.add(val);
                    break;
                case "pop":
                    if (q.isEmpty()) sb.append(-1);
                    else sb.append(q.remove(0));
                    sb.append('\n');
                    break;
                case "size":
                    sb.append(q.size()).append('\n');
                    break;
                case "empty":
                    if (q.isEmpty()) sb.append(1);
                    else sb.append(0);
                    sb.append('\n');
                    break;
                case "front":
                    if (q.isEmpty()) sb.append(-1);
                    else sb.append(q.get(0));
                    sb.append('\n');
                    break;
                case "back":
                    if (q.isEmpty()) sb.append(-1);
                    else sb.append(q.get(q.size() - 1));
                    sb.append('\n');
                    break;
            }
        }

        System.out.print(sb);
    }
}