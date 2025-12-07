import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();

        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String sub = str.substring(i, n);
            ans.add(sub);
        }

        Collections.sort(ans);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ans.get(i)).append('\n');
        }
        System.out.println(sb);
    }
}