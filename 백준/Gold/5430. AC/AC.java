import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String cmd = br.readLine();
            Deque<String> dq = new ArrayDeque<>();

            if (cmd.length() > 2) {
                String[] arr = cmd.substring(1, cmd.length()-1).split(",");
                for (String s : arr) {
                    dq.offer(s);
                }
            }

            boolean error = false;
            boolean left = true; // true: pollFirst, false: pollLast
            for (char c : p.toCharArray()) {
                if (c == 'D' && dq.isEmpty()) {
                    error = true;
                    break;
                }

                if (c == 'R') left = !left;
                else {
                    if (left) dq.poll();
                    else dq.pollLast();
                }
            }

            if (error) sb.append("error\n");
            else {
                sb.append('[');
                while (!dq.isEmpty()) {
                    if (left) sb.append(dq.poll()).append(',');
                    else sb.append(dq.pollLast()).append(',');
                }
                if (sb.charAt(sb.length() - 1) != '[') sb.deleteCharAt(sb.length() - 1);
                sb.append("]\n");
            }
        }

        System.out.println(sb);
    }
}