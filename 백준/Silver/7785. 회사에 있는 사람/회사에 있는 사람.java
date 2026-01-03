import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        TreeSet<String> inouts = new TreeSet<>(Collections.reverseOrder());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if (!inouts.add(name)) inouts.remove(name);
        }

        ArrayList<String> names = new ArrayList<>(inouts);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {
            sb.append(names.get(i)).append('\n');
        }
        System.out.println(sb);
    }
}