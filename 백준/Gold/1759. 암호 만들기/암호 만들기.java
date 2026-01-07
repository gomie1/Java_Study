import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char[] alpha, pwd;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alpha = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alpha[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alpha);

        isSelected = new boolean[C];
        pwd = new char[L];
        findPwd(0, 0);
        System.out.println(sb);
    }

    static void findPwd(int cnt, int start) {
        if (cnt == L) {
            if (isPwd()) {
                for (int i = 0; i < L; i++) {
                    sb.append(pwd[i]);
                }
                sb.append('\n');
            }
            return;
        }

        for (int i = start; i < C; i++) {
            if (!isSelected[i]) {
                pwd[cnt] = alpha[i];
                isSelected[i] = true;
                findPwd(cnt+1, i+1);
                isSelected[i] = false;
            }
        }
    }

    static boolean isPwd() {
        int consonant = 0; // 자음
        int vowel = 0; // 모음

        for (int i = 0; i < L; i++) {
            if (pwd[i] == 'a' || pwd[i] == 'e' || pwd[i] == 'i' || pwd[i] == 'o' || pwd[i] == 'u') vowel++;
            else consonant++;
        }

        if (consonant >= 2 && vowel >= 1) return true;
        else return false;
    }
}