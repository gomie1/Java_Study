import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean flag;
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;

            flag = true;
            Stack<Character> stack = new Stack<>();
            for (char c : str.toCharArray()) {
                if (c == '(' || c == '[') stack.add(c);
                else if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        flag = false;
                        break;
                    }
                }
                else if (c == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag && stack.isEmpty()) sb.append("yes\n");
            else sb.append("no\n");
        }

        System.out.print(sb);
    }
}