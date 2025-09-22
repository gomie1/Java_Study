import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] light = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            light[i] = Integer.parseInt(st.nextToken());
        }

        int student = Integer.parseInt(br.readLine());
        for (int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int j = number; j <= n; j += number) {
                    light[j] = (light[j] == 0) ? 1 : 0;
                }
            } else {
                int start = number;
                int end = number;

                while (start > 1 && end < n && light[start - 1] == light[end + 1]) {
                    start -= 1;
                    end += 1;
                }

                for (int j = start; j <= end; j++) {
                    light[j] = (light[j] == 0) ? 1 : 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(light[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
    }
}