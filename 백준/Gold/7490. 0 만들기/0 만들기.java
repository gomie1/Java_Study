import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            makeFormula(2, "1");
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void makeFormula (int num, String s) {
        if (num > N) {
            String formula = s.replace(" ", "");

            StringTokenizer st = new StringTokenizer(formula, "+-", true);
            int res = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                String op = st.nextToken();
                int nxtNum = Integer.parseInt(st.nextToken());

                if (op.equals("+")) res += nxtNum;
                else res -= nxtNum;
            }

            if (res == 0) sb.append(s).append('\n');
            return;
        }

        makeFormula(num+1, s+" "+num);
        makeFormula(num+1, s+"+"+num);
        makeFormula(num+1, s+"-"+num);
    }
}