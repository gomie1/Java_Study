import java.io.*;

public class Main {
    static String options[];
    static boolean chosen[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        options = new String[N];
        for (int i = 0; i < N; i++) {
            options[i] = br.readLine();
        }

        chosen = new boolean[26];
        for (int i = 0; i < N; i++) {
            String[] option = options[i].split(" ");
            boolean flag = false;

            for (int j = 0; j < option.length; j++) {
                char c = option[j].charAt(0);

                // 1. 단어의 첫 글자가 이미 단축키로 지정되었는지 체크
                if (isKey(c)) continue;

                // 아직 단축키로 지정되지 않았다면, 단축키 지정
                if (c >= 'A' && c <= 'Z') chosen[c - 'A'] = true;
                else chosen[c - 'a'] = true;
                setKey(i, j);
                flag = true;
                break;
            }

            if (flag) continue;

            // 2. 모든 단어의 첫 글자가 이미 지정이 되었다면 왼쪽부터 차례로 알파벳 탐색
            for (char c : options[i].toCharArray()) {
                if (c == ' ' || isKey(c) || flag) sb.append(c);
                else {
                    if (c >= 'A' && c <= 'Z') chosen[c - 'A'] = true;
                    else chosen[c - 'a'] = true;
                    sb.append('[').append(c).append(']');
                    flag = true;
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static boolean isKey(char c) {
        if (c >= 'A' && c <= 'Z' && chosen[c - 'A']) return true;
        if (c >= 'a' && c <= 'z' && chosen[c - 'a']) return true;
        return false;
    }

    static void setKey(int a, int b) {
        String[] str = options[a].split(" ");
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length(); j++) {
                if (i == b && j == 0) sb.append('[').append(str[i].charAt(j)).append(']');
                else sb.append(str[i].charAt(j));
            }
            sb.append(" ");
        }
        sb.append('\n');
    }
}