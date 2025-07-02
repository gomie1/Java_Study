import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            for (char c : br.readLine().toCharArray()) {
                if (c == '(') stack.add(c);
                else {
                    if (!stack.isEmpty()) stack.pop();
                    else {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag && stack.isEmpty()) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.print(sb);
    }
}