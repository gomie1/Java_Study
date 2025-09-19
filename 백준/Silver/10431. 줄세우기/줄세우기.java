import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < P; tc++) {
            ArrayList<Integer> arr = new ArrayList<>();
            int cnt = 0;

            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            sb.append(T).append(" ");

            int[] height = new int[20];
            for (int i = 0; i < 20; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            for (int h : height) {
                if (max < h) {
                    max = h;
                    arr.add(h);
                } else {
                    for (int i = 0; i < arr.size(); i++) {
                        if (arr.get(i) > h) {
                            cnt += arr.size() - i;
                            arr.add(i, h);
                            break;
                        }
                    }
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }
}