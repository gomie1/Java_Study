import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int exception = Math.round((float) n / 100 * 15);

        int[] opinion = new int[n];
        for (int i = 0; i < n; i++) {
            opinion[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(opinion);
        int sum = 0;
        for (int i = exception; i < n - exception; i++) {
            sum += opinion[i];
        }

        System.out.println(Math.round(sum / (float) (n - (2 * exception))));
    }
}