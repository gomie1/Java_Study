import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, arr[][], shark, res;
    static ArrayList<fish> fishInfo;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class fish implements Comparable<fish> {
        int x;
        int y;
        int dist;

        fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        // 거리가 가까운 물고기가 많다면 가장 위에 있는 물고기
        // 그러한 물고기가 여러 마리라면 가장 왼쪽에 있는 물고기를 먹음
        @Override
        public int compareTo(fish o) {
            if(this.dist != o.dist) return this.dist - o.dist;
            if(this.x != o.x) return this.x - o.x;
            return this.y - o.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 공간의 크기

        StringTokenizer st;
        arr = new int[N][N];
        fishInfo = new ArrayList<>();
        int start_x = 0;
        int start_y = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                // 물고기들의 정보 저장
                if(arr[i][j] != 0 && arr[i][j] != 9) {
                    fishInfo.add(new fish(i, j, Integer.MAX_VALUE));
                }

                // 아기 상어의 초기 위치 저장
                if(arr[i][j] == 9) {
                    start_x = i;
                    start_y = j;
                }
            }
        }

        shark = 2; // 아기상어의 처음 크기 = 2
        res = 0;
        BabyShark(start_x, start_y);
        System.out.println(res);
    }

    private static void BabyShark(int x, int y) {
        PriorityQueue<fish> isPossible = new PriorityQueue<>(); // 먹을 수 있는 물고기의 정보를 담을 큐
        int cnt = 0; // 아기 상어가 먹은 물고기의 수

        while(true) {
            // 1. 먹을 수 있는 물고기들을 추출 (우선순위 큐로 현재 아기 상어와의 거리가 짧은 순서대로 입력)
            for (fish f : fishInfo) {
                if(arr[f.x][f.y] < shark) { // 아기 상어는 자신보다 작은 물고기만 먹을 수 있음
                    f.dist = bfs(x, y, f);
                    isPossible.offer(f);
                }
            }

            // 2. 먹을 수 있는 물고기가 없거나 사방이 아기상어보다 큰 물고기들로 막혀서 이동할 수 없다면 종료
            if(isPossible.size() == 0 || isPossible.peek().dist == Integer.MAX_VALUE) break;

            // 3. 맨 앞 물고기를 먹고, 아기 상어의 현재 위치 갱신
            fish eatFish = isPossible.poll();
            fishInfo.remove(fishInfo.indexOf(eatFish));
            cnt++;
            if(cnt == shark) { // 아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가
                shark++;
                cnt = 0;
            }

            arr[x][y] = 0;
            x = eatFish.x;
            y = eatFish.y;
            arr[x][y] = 9;

            res += eatFish.dist; // 결과에 최소 거리만큼의 이동시간을 더해줌
            isPossible.clear();
        }
    }

    private static int bfs(int start_x, int start_y, fish curFish) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        q.add(new int[] {start_x, start_y, 0});
        visited[start_x][start_y] = true;

        int ans = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == curFish.x && cur[1] == curFish.y) {
                ans = cur[2];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || arr[nx][ny] > shark) continue;

                visited[nx][ny] = true;
                q.add(new int[] {nx, ny, cur[2]+1});
            }
        }
        return ans;
    }
}