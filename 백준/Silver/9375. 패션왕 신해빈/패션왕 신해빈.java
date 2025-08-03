import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> clothes = new HashMap<>();

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();

                clothes.put(type, clothes.getOrDefault(type, 0) + 1);
            }

            int ans = 1;
            for (String key : clothes.keySet()) {
                ans *= clothes.get(key) + 1;
            }

            sb.append(ans-1).append('\n');
        }

        System.out.print(sb);
    }
}