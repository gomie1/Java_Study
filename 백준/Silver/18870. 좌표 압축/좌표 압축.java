import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] X = new int[N];
        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortedX = X.clone();
        Arrays.sort(sortedX);

        HashMap<Integer, Integer> rank = new HashMap<>();
        int idx = 0;
        for (int v : sortedX) {
            if (!rank.containsKey(v)) rank.put(v, idx++);
        }

        StringBuilder sb = new StringBuilder();
        for (int v : X) {
            sb.append(rank.get(v)).append(" ");
        }

        System.out.println(sb);
    }
}