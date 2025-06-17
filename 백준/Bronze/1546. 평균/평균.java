import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] score = new double[N];
        double max = 0;
        for (int i = 0; i < N; i++) {
            score[i] = Double.parseDouble(st.nextToken());
            if (max < score[i]) max = score[i];
        }

        double sum = 0;
        for (double n : score) {
            sum += (n / max * 100);
        }

        System.out.println(sum / (double) N);
    }
}