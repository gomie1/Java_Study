import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        System.out.println(dfs(T, S));
    }

    static int dfs(String cur, String s) {
        if (cur.length() == s.length()) {
            return cur.equals(s) ? 1 : 0;
        }

        if (cur.charAt(cur.length()-1) == 'A') {
            if (dfs(cur.substring(0, cur.length()-1), s) == 1) return 1;
        }

        if (cur.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(cur.substring(1));
            if (dfs(sb.reverse().toString(), s) == 1) return 1;
        }

        return 0;
    }
}