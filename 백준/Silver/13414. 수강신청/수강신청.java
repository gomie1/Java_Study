import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> students = new LinkedHashSet<>();
        for (int i = 0; i < L; i++) {
            String num = br.readLine();
            if (!students.add(num)) {
                students.remove(num);
                students.add(num);
            }
        }

        StringBuilder sb = new StringBuilder();
        ArrayList<String> lst = new ArrayList<>(students);
        for (int i = 0; i < K; i++) {
            if (i < lst.size()) sb.append(lst.get(i)).append('\n');
        }
        System.out.println(sb);
    }
}