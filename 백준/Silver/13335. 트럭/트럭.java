import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] trucks = new int[n];
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> bridge = new ArrayDeque<>(); // 다리 {트럭 무게, 거리}
        // 현재 다리에 무게가 0인 트럭을 w개 채움 (거리 관리를 위함)
        for (int i = 0; i < w; i++) {
            bridge.offer(0);
        }

        int idx = 0; // 대기중인 트럭 중 가장 앞 트럭의 번호
        int weight = 0; // 다리 위 트럭의 총 무게
        int time = 0; // 걸린 시간
        while (!bridge.isEmpty()) {
            time++;

            // 1. 트럭 이동
            weight -= bridge.poll();

            // 2. 다음 트럭 진입 체크
            // 2-1) 다리에 이미 w대의 트럭이 있는 경우 -> Pass
            // 2-2) 다리에 진입한 트럭이 w대 보다는 적지만, 진입 시 다리 위의 트럭의 무게가 L을 초과하는 경우 -> Pass
            // 2-3) 현재 가장 앞에 있는 트럭이 다리에 진입 가능한 경우
            if (idx < n && bridge.size() < w && weight + trucks[idx] <= L) {
                bridge.offer(trucks[idx]); // 현재 트럭 다리에 진입
                weight += trucks[idx];
                idx++;
            } else if (idx < n && bridge.size() < w && weight + trucks[idx] > L) bridge.offer(0);
        }

        System.out.println(time);
    }
}