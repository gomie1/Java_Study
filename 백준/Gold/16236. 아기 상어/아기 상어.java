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
        int size;

        fish(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }

        // 거리가 가까운 물고기가 많다면 가장 위에 있는 물고기
        // 그러한 물고기가 여러 마리라면 가장 왼쪽에 있는 물고기를 먹음
        @Override
        public int compareTo(fish o) {
            if(this.x != o.x) {
                return this.x - o.x;
            }
            else {
                return this.y - o.y;
            }
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
                    fishInfo.add(new fish(i, j, arr[i][j]));
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
        ArrayList<fish> isPossible = new ArrayList<>(); // 먹을 수 있는 물고기의 정보를 담을 리스트
        int cnt = 0; // 아기 상어가 먹은 물고기의 수

        while(true) {
            // 1. 먹을 수 있는 물고기들을 추출
            for (fish f : fishInfo) {
                if(f.size < shark) { // 아기 상어는 자신보다 작은 물고기만 먹을 수 있음
                    isPossible.add(f);
                }
            }

            // 2. 먹을 수 있는 물고기가 없다면 종료 (엄마 상어에게 도움 요청!)
            if(isPossible.size() == 0) break;

            // * 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 감
            // * 먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 감

            // 3. 먹을 수 있는 물고기가 있다면, 아기 상어로부터 각 물고기까지의 최단거리를 구함
            int[] dist = new int[isPossible.size()];
            int minDist = Integer.MAX_VALUE;
            for (int i = 0; i < isPossible.size(); i++) {
                dist[i] = bfs(x, y, isPossible.get(i));
                if(dist[i] < minDist) minDist = dist[i];
            }
            if(minDist == Integer.MAX_VALUE) break; // 사방이 아기상어보다 큰 물고기들로 막혀서 이동할 수 없다면 종료

            // 4. 먹을 수 있는 물고기들 중 거리가 가장 가까운 물고기들만 추출
            ArrayList<fish> ans = new ArrayList<>();
            for (int i = 0; i < dist.length; i++) {
                if(dist[i] == minDist) ans.add(isPossible.get(i));
            }

            // 5. 물고기 정렬
            Collections.sort(ans);

            // 6. 맨 앞 물고기를 먹고, 아기 상어의 현재 위치 갱신
            fishInfo.remove(fishInfo.indexOf(ans.get(0)));
            cnt++;
            if(cnt == shark) { // 아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가
                shark++;
                cnt = 0;
            }

            arr[x][y] = 0;
            x = ans.get(0).x;
            y = ans.get(0).y;
            arr[x][y] = 9;

            res += minDist; // 결과에 최소 거리만큼의 이동시간을 더해줌
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