import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            for (char c : input.toCharArray()) {
                if (c == '(') stack.push(c);
                else {
                    if (!stack.isEmpty()) stack.pop();
                    else {
                        sb.append("NO").append('\n');
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                if (stack.isEmpty()) sb.append("YES").append('\n');
                else sb.append("NO").append('\n');
            }
        }

        System.out.println(sb);
    }
}