import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (char c : str.toCharArray()) {
            left.add(c);
        }

        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            if (cmd.charAt(0) == 'L' && !left.isEmpty()) right.add(left.pop());
            else if (cmd.charAt(0) == 'D' && !right.isEmpty()) left.add(right.pop());
            else if (cmd.charAt(0) == 'B' && !left.isEmpty()) left.pop();
            else if (cmd.charAt(0) == 'P') left.add(cmd.charAt(2));
        }

        StringBuilder sb = new StringBuilder();
        while (!left.isEmpty()) right.add(left.pop());
        while (!right.isEmpty()) sb.append(right.pop());
        System.out.println(sb);
    }
}