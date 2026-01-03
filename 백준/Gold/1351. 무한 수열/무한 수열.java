import java.io.*;
import java.util.*;

public class Main {
    static long N, P, Q;
    static HashMap<Long, Long> A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        A = new HashMap<>();
        A.put(Long.parseLong("0"), Long.parseLong("1"));

        System.out.println(findNum(N));
    }

    static long findNum(long i) {
        if (i == 0) return 1;
        if (A.containsKey(i)) return A.get(i);

        long res = findNum(i/P) + findNum(i/Q);
        A.put(i, res);
        return res;
    }
}