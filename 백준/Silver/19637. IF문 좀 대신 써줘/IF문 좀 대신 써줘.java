import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> name = new ArrayList<>();
        List<Integer> value = new ArrayList<>();
        int prev = -1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int b = Integer.parseInt(st.nextToken());

            if (prev != b) {
                name.add(a);
                value.add(b);
                prev = b;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int power = Integer.parseInt(br.readLine());
            // Collections.binarySearch(list, key)
            // - 리스트에 key 값과 정확히 일치하는 값이 있으면, 양수 또는 0을 반환
            // - 리스트에 key 값과 정확히 일치하는 값이 없다면, 음수(-(삽입점+1))를 반환
            // (* 삽입점? 리스트에서 key 값보다 크거나 같은 첫 번째 요소의 인덱스)
            int idx = Collections.binarySearch(value, power);

            if (idx < 0) idx = -(idx + 1); // 반환된 음수 값에서 삽입점 추출하기
            sb.append(name.get(idx)).append('\n');
        }

        System.out.println(sb);
    }
}