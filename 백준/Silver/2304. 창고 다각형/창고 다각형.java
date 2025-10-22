import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1. 기둥 정보 입력받기 및 최대 높이 찾기
        StringTokenizer st;
        int[][] storage = new int[N][2];
        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            storage[i][0] = Integer.parseInt(st.nextToken());
            storage[i][1] = Integer.parseInt(st.nextToken());
            if (maxHeight < storage[i][1]) maxHeight = storage[i][1];
        }

        // 2. 기둥 정렬
        Arrays.sort(storage, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        // 3. 창고 만들기
        int ans = 0;
        int prevX = storage[0][0];
        int prevY = storage[0][1];
        int left = prevX;
        for (int i = 1; i < N; i++) {
            if (prevY <= storage[i][1]) {
                ans += prevY * (storage[i][0] - prevX);
                prevX = storage[i][0];
                prevY = storage[i][1];

                if (storage[i][1] == maxHeight) {
                    left = prevX;
                    break;
                }
            }
        }

        prevX = storage[N-1][0];
        prevY = storage[N-1][1];
        int right = prevX;
        for (int i = N-2; i >= 0; i--) {
            if (prevY <= storage[i][1]) {
                ans += prevY * (prevX - storage[i][0]);
                prevX = storage[i][0];
                prevY = storage[i][1];

                if (storage[i][1] == maxHeight) {
                    right = prevX;
                    break;
                }
            }
        }
        
        ans += maxHeight * (right - left + 1);
        System.out.println(ans);
    }
}