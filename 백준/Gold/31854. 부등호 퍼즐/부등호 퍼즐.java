import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Pos[] pos;
    static ArrayList<Pos>[] graph;

    static class Pos implements Comparable<Pos> {
        int idx;
        int x;
        int y;
        int order;
        int num;

        public Pos(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.order = 0;
            this.num = 0;
        }

        @Override
        public int compareTo(Pos o) {
            return this.order - o.order;
        }
    }

    static void print() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N*N; i++) {
            if(i != 0 && i % N == 0) bw.write("\n");
            bw.write(pos[i].num + " ");
        }
        bw.write("\n");

        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        pos = new Pos[N * N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                pos[idx] = new Pos(idx, i, j);
                idx++;
            }
        }

        graph = new ArrayList[N*N];
        for (int i = 0; i < N*N; i++) {
            graph[i] = new ArrayList<>();
        }

        idx = 0;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N - 1; j++) {
                char s = st.nextToken().charAt(0);

                if (s == '<') {
                    graph[idx].add(pos[idx+1]);
                    pos[idx + 1].order++;
                }
                else {
                    graph[idx+1].add(pos[idx]);
                    pos[idx].order++;
                }
                idx++;
            }
            idx++;
        }

        idx = 0;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                char s = st.nextToken().charAt(0);
                if (s == '<') {
                    graph[idx].add(pos[idx+N]);
                    pos[idx + N].order++;
                }
                else {
                    graph[idx+N].add(pos[idx]);
                    pos[idx].order++;
                }

                idx++;
            }
        }

        topologySort();
        print();
    }
    
    private static void topologySort() {
        Queue<Pos> q = new LinkedList<>();
        for (int i = 0; i < N*N; i++) {
            if(pos[i].order == 0) q.offer(pos[i]);
        }

        int value = 1;
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            cur.num = value;
            value++;

            for(Pos p : graph[cur.idx]) {
                p.order--;
                if(p.order == 0) q.offer(p);
            }
        }
    }
}