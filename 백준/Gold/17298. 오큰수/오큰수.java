import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[N];
        for (int i = N-1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peekFirst() <= numbers[i]) stack.pollFirst();

            if (stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peekFirst();
            stack.addFirst(numbers[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append(" ");
        }

        System.out.println(sb);
    }
}