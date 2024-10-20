import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Time o) {
            return this.end != o.end ? this.end - o.end : this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 회의 개수

        StringTokenizer st;
        Time[] arr = new Time[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i] = new Time(start, end);
        }

        Arrays.sort(arr);
        ArrayList<Time> res = new ArrayList<>();
        res.add(arr[0]);
        for (int i = 1; i < N; i++) {
            // res에 넣은 마지막 회의가 다음 회의보다 빨리 끝난다면 다음 회의가 회의실 사용 가능
            if(res.get(res.size()-1).end <= arr[i].start) {
                res.add(arr[i]);
            }
        }

        System.out.println(res.size());
    }
}