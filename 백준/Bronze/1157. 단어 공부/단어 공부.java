import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.toUpperCase();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c,  0) + 1);
        }

        Character ans = 'a';
        int maxCnt = 0;
        int cnt = 1;
        for (char key : map.keySet()) {
            if (maxCnt < map.get(key)) {
                ans = key;
                maxCnt = map.get(key);
                cnt = 1;
            } else if (maxCnt == map.get(key)) cnt++;
        }

        System.out.println(cnt == 1 ? ans : '?');
    }
}