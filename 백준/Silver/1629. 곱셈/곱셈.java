import java.io.*;
import java.util.*;

public class Main {
    static long A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(dfs(A % C, B));
    }

    static long dfs(long x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x % C;

        long y = dfs(x, n/2);
        long tmp = (y * y) % C;
        
        if (n % 2 == 0) return tmp;
        else return (tmp * x) % C;
    }
}