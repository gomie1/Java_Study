import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        int P = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> D = new ArrayDeque<>();
        D.add(Integer.parseInt(A));

        boolean flag = false;
        int cnt = 0;
        while (!flag) {
            String cur = Integer.toString(D.peekLast());
            int num = 0;
            for (char c : cur.toCharArray()) {
                num += Math.pow(c - '0', P);
            }

            if (D.contains(num)) {
                while (true) {
                    int n = D.pollFirst();
                    if (n == num) {
                        flag = true;
                        break;
                    }
                    cnt++;
                }
            } else D.add(num);
        }

        System.out.println(cnt);
    }
}