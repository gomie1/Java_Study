import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        while(q.size() > 1) {
            q.poll(); // 1. 제일 위에 있는 카드 버리기
            q.offer(q.poll()); // 2. 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮기기
        }

        System.out.println(q.poll());
    }
}