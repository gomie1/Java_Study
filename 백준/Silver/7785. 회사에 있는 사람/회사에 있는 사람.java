import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        HashSet<String> inouts = new HashSet<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if (!inouts.contains(name)) inouts.add(name);
            else inouts.remove(name);
        }

        Iterator<String> itr = inouts.iterator();
        ArrayList<String> names = new ArrayList<>();
        while (itr.hasNext()) names.add(itr.next());

        StringBuilder sb = new StringBuilder();
        Collections.sort(names, Collections.reverseOrder());
        for (int i = 0; i < names.size(); i++) {
            sb.append(names.get(i)).append('\n');
        }
        System.out.println(sb);
    }
}