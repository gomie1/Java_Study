import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        int[][] apartment = new int[15][15];
        for (int a = 0; a < 15; a++) {
            for (int b = 1; b < 15; b++) {
                if (a == 0) apartment[a][b] = b;
                else apartment[a][b] = apartment[a][b-1] + apartment[a-1][b];
            }
        }

        StringBuilder sb = new StringBuilder();
        int k, n;
        for (int i = 0; i < tc; i++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            sb.append(apartment[k][n]).append('\n');
        }

        System.out.print(sb);
    }
}