import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> input = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();
        double sum = 0;
        int[] cnt = new int[8001];
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            input.add(val);
            numSet.add(val);
            sum += val;
            cnt[val + 4000]++;
        }
        Collections.sort(input);

        int maxCnt = 0;
        for (int n : numSet) {
            if (maxCnt < cnt[n + 4000]) maxCnt = cnt[n + 4000];
        }

        List<Integer> cntList = new ArrayList<>();
        for (int n : numSet) {
            if (cnt[n + 4000] == maxCnt) cntList.add(n);
        }
        Collections.sort(cntList);

        StringBuilder sb = new StringBuilder();
        sb.append(Math.round(sum / N)).append('\n');
        sb.append(input.get(N/2)).append('\n');
        sb.append(cntList.size() > 1 ? cntList.get(1) : cntList.get(0)).append('\n');
        sb.append(input.get(N-1) - input.get(0));
        System.out.println(sb);
    }
}