import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1. 기준 단어 설정 및 알파벳 개수 계산
        String word = br.readLine();
        char[] wordAlpha = new char[26];
        for (char c : word.toCharArray()) wordAlpha[c - 'A']++;

        int ans = 0;
        // 2. 나머지 N-1개의 단어를 순회하며 비교
        for (int i = 0; i < N-1; i++) {
            String str = br.readLine();
            char[] strAlpha = new char[26];
            for (char c : str.toCharArray()) strAlpha[c - 'A']++;

            // 3. 일치하는 알파벳 개수 계산
            int matchCnt = 0;
            for (int j = 0; j < 26; j++) {
                matchCnt += Math.min(wordAlpha[j], strAlpha[j]); // 둘 중 하나라도 해당 알파벳이 없다면 0을 더함
            }

            // 4. 비슷한 단어 조건 확인
            // A. 길이가 같은 경우
            if (word.length() == str.length()) {
                if (matchCnt == word.length() || matchCnt == word.length() - 1) ans++;
            }

            // B. 길이가 1 차이 나는 경우
            else if (Math.abs(word.length() - str.length()) == 1) {
                // 이 경우, 짧은 단어의 모든 문자는 긴 단어에 포함되어야 함
                // -> 즉, matchCnt는 짧은 단어의 길이와 같아야 함!
                if (matchCnt == Math.min(word.length(), str.length())) ans++;
            }
            // 길이가 2 이상 차이 나는 경우는 무조건 비슷한 단어가 아님 (Pass)
        }

        System.out.println(ans);
    }
}