import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] students = new boolean[31];
        for (int i = 0; i < 28; i++) {
            students[Integer.parseInt(br.readLine())] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 30; i++) {
            if (!students[i]) sb.append(i).append('\n');
        }

        System.out.println(sb);
    }
}