import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] cmd = br.readLine().split(" ");
            if (cmd[0].equals("push")) stack.push(cmd[1]);
            else if (cmd[0].equals("pop")) {
                if (stack.isEmpty()) sb.append(-1).append('\n');
                else sb.append(stack.pop()).append('\n');
            } else if (cmd[0].equals("size")) sb.append(stack.size()).append('\n');
            else if (cmd[0].equals("empty")) {
                if (stack.isEmpty()) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            } else {
                if (stack.isEmpty()) sb.append(-1).append('\n');
                else sb.append(stack.peek()).append('\n');
            }
        }

        System.out.println(sb);
    }
}