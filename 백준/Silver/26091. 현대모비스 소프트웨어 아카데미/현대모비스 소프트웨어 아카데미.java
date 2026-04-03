import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 학회원의 수
        int M = Integer.parseInt(st.nextToken()); // 팀의 최소 능력치

        st = new StringTokenizer(br.readLine());
        int[] power = new int[N]; // 학회원들의 능력치
        for (int i = 0; i < N; i++) {
            power[i] = Integer.parseInt(st.nextToken());
        }

        // 학회원의 수가 1명이라면 팀을 만들 수 없음
        if (N == 1) {
            System.out.println(0);
            return;
        }

        Arrays.sort(power);
        int left = 0;
        int right = N-1;
        int cnt = 0;
        while (left < right) {
            if (power[left] + power[right] >= M) {
                cnt++;
                right--;
            }
            left++;
        }

        System.out.println(cnt);
    }
}