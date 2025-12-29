import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>(); // {위치, 높이}
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());

            // 1. 현재보다 낮은 탑들은 신호를 받지 못하므로 다 제거
            while (!stack.isEmpty() && stack.peek()[1] < height) stack.pop();

            // 2. 결과 출력
            if (stack.isEmpty()) sb.append("0 ");
            else sb.append(stack.peek()[0]).append(" ");

            // 3. 현재 탑을 스택에 추가
            stack.push(new int[] {i, height});
        }

        System.out.println(sb.toString().trim());
    }
}