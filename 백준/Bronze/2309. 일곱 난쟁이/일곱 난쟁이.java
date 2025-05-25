import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = new int[9];
    static List<Integer> ans = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean found;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        combination(0, 0, 0);
        System.out.println(sb);
    }

    static void combination(int sum, int start, int depth) {
        if(found) return;

        if (depth == 7) {
            if (sum == 100) {
                Collections.sort(ans);
                for (int num : ans) sb.append(num).append("\n");
                found = true;
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            ans.add(arr[i]);
            combination(sum + arr[i], i + 1, depth + 1);
            ans.remove(ans.size() - 1);
        }
    }
}