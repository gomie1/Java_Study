import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("end")) break;

            char[] pwd = input.toCharArray();
            boolean vowel = false;
            int cnt1 = 0; // 연속된 모음의 개수
            int cnt2 = 0; // 연속된 자음의 개수
            boolean acceptable = true;
            for (int i = 0; i < pwd.length; i++) {
                // 1. 모음 관련 검사
                if (pwd[i] == 'a' || pwd[i] == 'e' || pwd[i] == 'i' || pwd[i] == 'o' || pwd[i] == 'u') {
                    vowel = true;
                    if (++cnt1 == 3) {
                        acceptable = false;
                        break;
                    }
                    cnt2 = 0;
                } else { // 2. 자음 관련 검사
                    if (++cnt2 == 3) {
                        acceptable = false;
                        break;
                    }
                    cnt1 = 0;
                }

                // 3. 연속되는 같은 글자 검사
                if (i > 0) {
                    if (pwd[i-1] == pwd[i]) {
                        if ((pwd[i-1] == 'e' && pwd[i] == 'e') || (pwd[i-1] == 'o' && pwd[i] == 'o')) continue;
                        else {
                            acceptable = false;
                            break;
                        }
                    }
                }
            }

            if (vowel && acceptable) sb.append("<").append(input).append("> is acceptable.\n");
            else sb.append("<").append(input).append("> is not acceptable.\n");
        }

        System.out.println(sb);
    }
}