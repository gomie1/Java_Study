import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int room = 0; room < 5; room++) { // 대기실 번호
            // 1. 응시자 자리 좌표 모으기
            List<int[]> pos = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if (places[room][i].charAt(j) == 'P') pos.add(new int[] {i, j});
                }
            }
            
            if (pos.isEmpty()) { // 응시자가 없는 경우 거리두기를 지키고 있다고 판단
                answer[room] = 1;
                continue;
            }

            // 2. 각 좌표에서 다른 응시자가 앉을 수 없는 자리 탐색 + 응시자 여부 확인
            answer[room] = 1; // 모든 응시자가 거리두기를 지키고 있다고 가정
            for (int i = 0; i < pos.size(); i++) {
                if (!bfs(pos.get(i), places[room])) { // 한 명이라도 지키지 않는다면 false처리
                    answer[room] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    static boolean bfs(int[] start, String[] map) {
        Queue<int[]> q = new LinkedList<>(); // {x, y, dist}
        q.add(new int[] {start[0], start[1], 0});
        boolean[][] visited = new boolean[5][5];
        visited[start[0]][start[1]] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[2] >= 2) continue; // 거리가 2 이상이면 더 이상 다음 위치를 볼 필요 없음
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visited[nx][ny]) continue;
                
                // 다음 위치가 파티션인 경우 PASS (파티션을 피해서 도착하면 어차피 맨해튼 거리가 2가 넘기 때문)
                if (map[nx].charAt(ny) == 'X') continue;
                
                // 다음 위치가 사람인 경우 거리두기 위반!!
                if (map[nx].charAt(ny) == 'P') return false;
                
                // 다음 위치가 비어있는 경우, 거리를 갱신한 채로 이동
                q.add(new int[] {nx, ny, cur[2]+1});
                visited[nx][ny] = true;
            }
        }
        
        return true;
    }
}