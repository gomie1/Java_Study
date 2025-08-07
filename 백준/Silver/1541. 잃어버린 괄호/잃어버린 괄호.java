import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("-");

        int sum = 0;
        for (int i = 0; i < parts.length; i++) {
            String[] numbers = parts[i].split("\\+");
            int tmp = 0;
            for (String num : numbers) {
                tmp += Integer.parseInt(num);
            }

            if (i == 0) sum += tmp;
            else sum -= tmp;
        }

        System.out.println(sum);
    }
}