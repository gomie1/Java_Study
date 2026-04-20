import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(br.readLine());
            return;
        }

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int one = 0;
        int zero = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) zero++;
            else if (num == 1) one++;
            else if (num > 1) pos.add(num);
            else neg.add(num);
        }

        int sum = 0;
        // 1. 1보다 큰 양수: 곱할수록 합이 최대가 됨 (내림차순)
        pos.sort(Collections.reverseOrder());
        for (int i = 0; i < pos.size(); i += 2) {
            if (i+1 < pos.size()) sum += pos.get(i) * pos.get(i+1);
            else sum += pos.get(i);
        }

        // 2. 1: 1은 어떤 수와 곱하는 것보다 그냥 더하는 것이 이득임
        if (one > 0) sum += one;

        // 3. 음수: 음수끼리 곱하면 양수가 됨
        Collections.sort(neg);
        for (int i = 0; i < neg.size(); i += 2) {
            if (i+1 < neg.size()) sum += neg.get(i) * neg.get(i+1);
            else {
                // 4. 0: 남은 음수가 하나일 때, 그 음수를 0과 곱해서 없애버리는 것이 이득임
                if (zero == 0) sum += neg.get(i);
            }
        }

        System.out.println(sum);
    }
}