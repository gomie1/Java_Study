import java.util.*;

class Solution {
    static ArrayList<Integer>[] getOil;
    
    public int solution(int[][] land) {
        getOil = new ArrayList[land[0].length];
        for (int i = 0; i < land[0].length; i++) {
            getOil[i] = new ArrayList<>();
        }
        
        // 1. 석유 덩어리마다 번호 부여 및 각 덩어리의 크기 저장
        int num = 2; // 덩어리 번호는 2번부터 시작
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    int cnt = bfs(land, i, j, num);
                    map.put(num++, cnt);
                }
            }
        }
        
        // 2. 각 열마다 뽑을 수 있는 석유의 양 계산 및 최대값 찾기
        int answer = 0;
        for (int i = 0; i < land[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < getOil[i].size(); j++) {
                sum += map.get(getOil[i].get(j));
            }
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
    
    static int bfs(int[][] land, int sx, int sy, int num) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        land[sx][sy] = num;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int cnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            cnt++;
            // bfs 과정에서 미리 각 열마다 포함되는 덩어리 번호 기록!
            if (!getOil[cur[1]].contains(num)) getOil[cur[1]].add(num);
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx < 0 || nx >= land.length || ny < 0 || ny >= land[0].length || land[nx][ny] != 1) continue;
                q.offer(new int[]{nx, ny});
                land[nx][ny] = num;
            }
        }
        
        return cnt;
    }
}