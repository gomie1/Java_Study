import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            int k = Integer.parseInt(br.readLine()); // 연산의 개수

            TreeMap<Integer, Integer> map = new TreeMap<>();
            StringTokenizer st;
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());

                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (cmd.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (num == -1) { // 최솟값 삭제
                        if (!map.isEmpty()) {
                            Map.Entry<Integer, Integer> first = map.firstEntry();

                            if (first.getValue() > 1) map.put(first.getKey(), first.getValue() - 1);
                            else map.remove(first.getKey());
                        }
                    } else { // 최대값 삭제
                        if (!map.isEmpty()) {
                            Map.Entry<Integer, Integer> last = map.lastEntry();

                            if (last.getValue() > 1) map.put(last.getKey(), last.getValue() - 1);
                            else map.remove(last.getKey());
                        }
                    }
                }
            }

            if (map.isEmpty()) sb.append("EMPTY\n");
            else sb.append(map.lastKey()).append(" ").append(map.firstKey()).append('\n');
        }

        System.out.println(sb);
    }
}