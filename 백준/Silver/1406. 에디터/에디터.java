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
            String[] cmd = br.readLine().split(" ");
            if (cmd[0].equals("L") && !left.isEmpty()) right.add(left.pop());
            else if (cmd[0].equals("D") && !right.isEmpty()) left.add(right.pop());
            else if (cmd[0].equals("B") && !left.isEmpty()) left.pop();
            else if (cmd[0].equals("P")) left.add(cmd[1].charAt(0));
        }

        StringBuilder sb = new StringBuilder();
        while (!left.isEmpty()) right.add(left.pop());
        while (!right.isEmpty()) sb.append(right.pop());
        System.out.println(sb);
    }
}