import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            if (arr[0] + arr[1] + arr[2] == 0) break;

            if (arr[2] >= arr[0] + arr[1]) sb.append("Invalid").append("\n");
            else {
                if (arr[0] == arr[1] && arr[1] == arr[2]) {
                    sb.append("Equilateral").append("\n");
                } else if (arr[0] == arr[1] || arr[1] == arr[2] || arr[2] == arr[0]) {
                    sb.append("Isosceles").append("\n");
                } else {
                    sb.append("Scalene").append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}