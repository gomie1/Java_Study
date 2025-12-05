import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pipe = br.readLine();
        
        Stack<Character> stack = new Stack<>();
        boolean right = false;
        int ans = 0;
        for (char c : pipe.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                if (right) right = false;
            } else {
                if (!right) { // 레이저인 경우
                    stack.pop();
                    if (!stack.isEmpty()) ans += stack.size();
                    right = true;
                } else {
                    ans++;
                    stack.pop();
                }
            }
        }

        System.out.println(ans);
     }
}