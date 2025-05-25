import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String order = br.readLine();
            int value = 0;
            if (order.contains("push")) {
                String s = "";
                for (int j = 5; j < order.length(); j++) {
                    s += order.charAt(j);
                }
                value = Integer.parseInt(s);
                order = "push";
            }

            switch (order) {
                case "push":
                    stack.push(value);
                    break;
                case "top":
                    if (stack.isEmpty()) sb.append(-1);
                    else sb.append(stack.get(stack.size() - 1));
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if (stack.isEmpty()) sb.append(1);
                    else sb.append(0);
                    sb.append("\n");
                    break;
                case "pop":
                    if (stack.isEmpty()) sb.append(-1);
                    else sb.append(stack.pop());
                    sb.append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}