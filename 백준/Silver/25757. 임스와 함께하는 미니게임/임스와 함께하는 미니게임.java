import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        Set<String> name = new HashSet<>();
        for (int i = 0; i < N; i++) {
            name.add(br.readLine());
        }

        if (game.equals("Y")) System.out.println(name.size());
        else if (game.equals("F")) System.out.println(name.size() / 2);
        else System.out.println(name.size() / 3);
    }
}