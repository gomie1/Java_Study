import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<String> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] cmd = br.readLine().split(" ");

            if (cmd[0].equals("push_front")) dq.addFirst(cmd[1]);
            else if (cmd[0].equals("push_back")) dq.addLast(cmd[1]);
            else if (cmd[0].equals("pop_front")) {
                if (dq.isEmpty()) sb.append(-1).append('\n');
                else sb.append(dq.removeFirst()).append('\n');
            } else if (cmd[0].equals("pop_back")) {
                if (dq.isEmpty()) sb.append(-1).append('\n');
                else sb.append(dq.removeLast()).append('\n');
            } else if (cmd[0].equals("size")) sb.append(dq.size()).append('\n');
            else if (cmd[0].equals("empty")) {
                if (dq.isEmpty()) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            } else if (cmd[0].equals("front")) {
                if (dq.isEmpty()) sb.append(-1).append('\n');
                else sb.append(dq.peekFirst()).append('\n');
            } else {
                if (dq.isEmpty()) sb.append(-1).append('\n');
                else sb.append(dq.peekLast()).append('\n');
            }
        }

        System.out.println(sb);
     }
}