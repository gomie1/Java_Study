import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        int num = 1;
        StringBuilder sb = new StringBuilder();
        stack.add(num++);
        sb.append("+\n");

        while (idx < n) {
            if (!stack.isEmpty() && stack.peek() == arr[idx]) {
                stack.pop();
                idx++;
                sb.append("-\n");
            } else if (!stack.isEmpty() && stack.peek() > arr[idx]) {
                System.out.println("NO");
                return;
            } else {
                stack.add(num++);
                sb.append("+\n");
            }
        }

        System.out.print(sb);
    }
}