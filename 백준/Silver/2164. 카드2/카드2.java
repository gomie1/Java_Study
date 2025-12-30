import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dq.offer(i);
        }

        while (dq.size() > 1) {
            // 1. 제일 위에 있는 카드 버리기
            dq.poll();

            // 2. 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮기기
            dq.offer(dq.poll());
        }

        System.out.println(dq.peek());
    }
}