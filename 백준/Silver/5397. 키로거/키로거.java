import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder tmp = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            String L = br.readLine();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            for (char c : L.toCharArray()) {
                switch (c) {
                    case '<':
                        if (!left.isEmpty()) right.push(left.pop());
                        break;
                    case '>':
                        if (!right.isEmpty()) left.push(right.pop());
                        break;
                    case '-':
                        if (!left.isEmpty()) left.pop();
                        break;
                    default:
                        left.push(c);
                        break;
                }
            }

            while (!left.isEmpty()) tmp.append(left.pop());
            tmp.reverse();
            while (!right.isEmpty()) tmp.append(right.pop());
            sb.append(tmp).append('\n');
            tmp.delete(0, tmp.length());
        }

        System.out.println(sb);
    }
}