import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int d;
    static char[] num;
    static long x, y, cx, cy;
    static String res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken()); // 사분면 조각 번호의 자릿수

        num = st.nextToken().toCharArray(); // 사분면 조각 번호

        st = new StringTokenizer(br.readLine());
        y = Long.parseLong(st.nextToken()); // y축 이동 횟수
        x = Long.parseLong(st.nextToken()); // x축 이동 횟수

        // 1. 사분면 조각 번호의 위치 찾기
        cx = 0;
        cy = 0;
        findPos(d);

        // 2. 찾고자 하는 사분면 조각 번호의 위치 계산
        cx -= x;
        cy += y;

        // 3. 이동한 위치의 번호 찾기
        res = "";
        findNum();

        if(res.length() == d) System.out.println(res);
        else System.out.println(-1);
    }

    private static void findPos(int a) {
        long size;

        for(char n : num) {
            a--;
            size = (long) Math.pow(2, a);

            if(n == '1') {
                cy += size;
            }
            else if(n == '3') {
                cx += size;
            }
            else if(n == '4') {
                cx += size;
                cy += size;
            }
        }
    }

    private static void findNum() {
        long half;

        for (int i = 0; i < d; i++) {
            half = (long) Math.pow(2, d-i-1); // 4

            if(0 <= cx && cx < half && 0 <= cy && cy < half) {
                res += "2";
            }
            else if(0 <= cx && cx < half && half <= cy && cy < half*2) {
                cy -= half;
                res += "1";
            }
            else if(half <= cx && cx < half*2 && 0 <= cy && cy < half) {
                cx -= half;
                res += "3";
            }
            else if(half <= cx && cx < half*2 && half <= cy && cy < half*2) {
                cx -= half;
                cy -= half;
                res += "4";
            }
        }
    }
}