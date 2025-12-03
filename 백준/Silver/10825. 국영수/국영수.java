import java.io.*;
import java.util.*;

public class Main {
    static class StInfo implements Comparable<StInfo> {
        String name;
        int korean;
        int math;
        int english;

        public StInfo(String name, int s1, int s2, int s3) {
            this.name = name;
            this.korean = s1;
            this.math = s2;
            this.english = s3;
        }

        @Override
        public int compareTo(StInfo o) {
            if (this.korean != o.korean) return o.korean - this.korean;
            if (this.math != o.math) return this.math - o.math;
            if (this.english != o.english) return o.english - this.english;
            return this.name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StInfo[] info = new StInfo[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            info[i] = new StInfo(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(info);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(info[i].name).append('\n');
        }

        System.out.println(sb);
    }
}