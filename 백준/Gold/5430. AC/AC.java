import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            String p = br.readLine();

            int n = Integer.parseInt(br.readLine());
            Deque<String> dq = new ArrayDeque<>(n); // 초기 용량을 n개로 미리 설정
            String str = br.readLine();
            if (n > 0) {
                String[] parts = str.substring(1, str.length()-1).split(",");
                for (String s : parts) dq.offer(s);
            }

            boolean isChange = false;
            boolean isError = false;
            for (char c : p.toCharArray()) {
                if (c == 'R') isChange = !isChange;
                else {
                    if (dq.isEmpty()) {
                        sb.append("error\n");
                        isError = true;
                        break;
                    }

                    if (!isChange) dq.poll();
                    else dq.pollLast();
                }
            }

            if (!isError) {
                sb.append('[');

                if (!dq.isEmpty()) {
                    Iterator<String> it;
                    if (!isChange) it = dq.iterator();
                    else it = dq.descendingIterator();

                    while (it.hasNext()) {
                        sb.append(it.next());
                        if (it.hasNext()) sb.append(',');
                    }
                }

                sb.append("]\n");
            }
        }

        System.out.println(sb);
    }
}