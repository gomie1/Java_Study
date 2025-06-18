import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals("0")) break;

            Deque<Character> deque = new ArrayDeque<>();
            for (char c : str.toCharArray()) {
                deque.addLast(c);
            }

            boolean isPalindrome = true;
            while (deque.size() > 1) {
                if (deque.pollFirst() != deque.pollLast()) {
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) sb.append("yes").append('\n');
            else sb.append("no").append('\n');
        }

        System.out.print(sb);
    }
}