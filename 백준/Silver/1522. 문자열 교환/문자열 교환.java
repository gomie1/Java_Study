import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();

        int aCnt = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'a') aCnt++;
        }

        if (aCnt == str.length) {
            System.out.println(0);
            return;
        }

        int start = 0;
        int end = aCnt;
        int bCnt = 0;
        int ans = str.length;
        for (int i = start; i < end; i++) {
            if (str[i] == 'b') bCnt++;
        }
        ans = Math.min(ans, bCnt);

        while (start < str.length) {
            // 1. 맨 앞 빼기
            if (str[start] == 'b') bCnt--;
            start++;

            // 2. 뒤 넣기
            if (str[end] == 'b') bCnt++;
            end = ++end % str.length;

            // 3. 최소값 갱신
            ans = Math.min(ans, bCnt);
        }

        System.out.println(ans);
    }
}