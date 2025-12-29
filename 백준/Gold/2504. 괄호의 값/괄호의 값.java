import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int ans = 0;
        int tmp = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                tmp *= 2;
                stack.push(c);
            } else if (c == '[') {
                tmp *= 3;
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }

                if (str.charAt(i-1) == '(') ans += tmp;
                tmp /= 2;
                stack.pop();
            } else {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }

                if (str.charAt(i-1) == '[') ans += tmp;
                tmp /= 3;
                stack.pop();
            }
        }
        
        if (!stack.isEmpty()) System.out.println(0);
        else System.out.println(ans);
    }
}