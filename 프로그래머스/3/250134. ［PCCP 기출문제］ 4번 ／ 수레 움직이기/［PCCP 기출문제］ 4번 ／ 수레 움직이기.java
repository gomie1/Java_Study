import java.util.*;

class Solution {
    static int n, m, answer, maze[][];
    static boolean[][] visitedRed;
    static boolean[][] visitedBlue;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maze) {
        n = maze.length;
        m = maze[0].length;
        this.maze = maze;
        
        // 1. 각 수레의 시작 위치 찾기
        int rx = 0, ry = 0;
        int bx = 0, by = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 1) {
                    rx = i;
                    ry = j;
                } else if (maze[i][j] == 2) {
                    bx = i;
                    by = j;
                }
            }
        }
        
        answer = Integer.MAX_VALUE;
        visitedRed = new boolean[n][m];
        visitedBlue = new boolean[n][m];
        
        // 2. 시작 칸 방문 처리
        visitedRed[rx][ry] = true;
        visitedBlue[bx][by] = true;
        
        // 3. 이동 시작
        move(rx, ry, bx, by, 0, false, false);
        
        return (answer == Integer.MAX_VALUE) ? 0 : answer;
    }
    
    static void move(int rx, int ry, int bx, int by, int moveCnt, boolean redEnd, boolean blueEnd) {
        // 각 수레의 현재 위치가 도착 지점이라면 도착 처리
        if (!redEnd && maze[rx][ry] == 3) redEnd = true;
        if (!blueEnd && maze[bx][by] == 4) blueEnd = true;
        
        // 종료 조건: 두 수레 모두 도착했다면 이동 횟수 최소값 갱신 후 종료
        if (redEnd && blueEnd) {
            answer = Math.min(answer, moveCnt);
            return;
        }
        
        ArrayList<int[]> redLst = new ArrayList<>(); // 빨간 수레의 이동 가능 위치들
        ArrayList<int[]> blueLst = new ArrayList<>(); // 파란 수레의 이동 가능 위치들
        
        // a. 빨간 수레의 이동 가능한 위치 찾기
        if (!redEnd) { // 아직 빨간 수레가 도착하지 않았다면 상하좌우로 이동 가능
            for (int i = 0; i < 4; i++) {
                int nrx = rx + dx[i];
                int nry = ry + dy[i];
                
                // 다음 위치가 격자를 벗어나거나 벽이거나 이미 방문했었다면 해당 위치로 이동 불가
                if (nrx < 0 || nrx >= n || nry < 0 || nry >= m 
                    || maze[nrx][nry] == 5 || visitedRed[nrx][nry]) continue;
                
                // 이동 가능한 위치라면 위치를 리스트에 삽입
                redLst.add(new int[] {nrx, nry});
            }
        } else redLst.add(new int[] {rx, ry}); // 이미 빨간 수레가 도착했다면 이동 불가능 (위치 그대로)
        
        // b. 파란 수레의 이동 가능한 위치 찾기 (a와 로직 동일)
        if (!blueEnd) {
            for (int i = 0; i < 4; i++) {
                int nbx = bx + dx[i];
                int nby = by + dy[i];
                
                if (nbx < 0 || nbx >= n || nby < 0 || nby >= m 
                    || maze[nbx][nby] == 5 || visitedBlue[nbx][nby]) continue;
                
                blueLst.add(new int[] {nbx, nby});
            }
        } else blueLst.add(new int[] {bx, by});
        
        // 빨간 수레와 파란 수레의 가능한 다음 위치들로 다음 턴 조합
        for (int i = 0; i < redLst.size(); i++) {
            int[] redPos = redLst.get(i);
            
            for (int j = 0; j < blueLst.size(); j++) {
                int[] bluePos = blueLst.get(j);
                
                // 조건 1. 동시에 두 수레를 같은 칸으로 움직일 수 없음
                if (redPos[0] == bluePos[0] && redPos[1] == bluePos[1]) continue;
                
                // 조건 2. 수레끼리 자리를 바꾸며 움직일 수 없음
                if ((rx == bluePos[0] && ry == bluePos[1]) 
                    && (bx == redPos[0] && by == redPos[1])) continue;
                
                // 다음 위치로 이동
                visitedRed[redPos[0]][redPos[1]] = true;
                visitedBlue[bluePos[0]][bluePos[1]] = true;
                
                move(redPos[0], redPos[1], bluePos[0], bluePos[1], moveCnt+1, redEnd, blueEnd);
                
                // 다른 조합의 경우를 위한 백트래킹
                visitedRed[redPos[0]][redPos[1]] = false;
                visitedBlue[bluePos[0]][bluePos[1]] = false;
            }
        }
    }
}