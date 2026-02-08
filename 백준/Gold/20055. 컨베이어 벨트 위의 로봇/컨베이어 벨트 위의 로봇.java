import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static class Belt {
        int power;
        boolean isRobot;

        Belt (int p) {
            this.power = p;
            this.isRobot = false;
        }
    }
    static int N;
    static List<Belt> belt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        belt = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2*N; i++) {
            belt.add(new Belt(Integer.parseInt(st.nextToken())));
        }
        
        int step = 0;
        int zeroCnt = 0;
        while (true) {
            step++;

            // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전
            rotate();
            // 내리는 위치(N-1)에 로봇이 있다면 내리기
            belt.get(N-1).isRobot = false;

            // 2. 가장 먼저 벨트에 올라간 로봇부터, 한 칸 이동 (이동할 수 없다면 가만히)
            // * 가장 먼저 올라간 로봇 = 내리는 위치에 가까운 로봇
            for (int i = N-2; i >= 0; i--) {
                if (belt.get(i).isRobot) {
                    int nxt = i + 1;
                    if (!belt.get(nxt).isRobot && belt.get(nxt).power > 0) {
                        belt.get(i).isRobot = false;
                        belt.get(nxt).isRobot = true;
                        belt.get(nxt).power--;
                        if (belt.get(nxt).power == 0) zeroCnt++;
                    }
                }
            }

            // 이동 후에도 내리는 위치 체크
            belt.get(N-1).isRobot = false;

            // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니라면 로봇 올리기
            if (belt.get(0).power > 0) {
                belt.get(0).isRobot = true;
                belt.get(0).power--;
                if (belt.get(0).power == 0) zeroCnt++;
            }

            // 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정 종료
            if (zeroCnt >= K) break;
        }

        System.out.println(step);
    }

    static void rotate() {
        belt.add(0, belt.get(2*N-1));
        belt.remove(2*N);
    }
}