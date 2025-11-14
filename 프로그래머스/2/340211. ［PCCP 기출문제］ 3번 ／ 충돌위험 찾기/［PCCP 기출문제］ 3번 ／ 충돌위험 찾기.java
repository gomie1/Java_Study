import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int n = routes.length;
        
        // 1. 각 로봇마다 최단 경로로 갈 수 있는 루트 찾기
        ArrayList<String>[] path = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            path[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < routes[i].length; j++) {
                int[] start = points[routes[i][j-1] - 1];
                int[] end = points[routes[i][j] - 1];
                //System.out.println("start = " + start[0] + " " + start[1] + ", end = " + end[0] + " " + end[1]);

                ArrayList<String> pos = findAllPath(start[0], start[1], end[0], end[1]);
                for (int k = 0; k < pos.size(); k++) {
                    if (j < routes[i].length - 1 && k == pos.size() - 1) continue;
                    path[i].add(pos.get(k));
                }
                
                // for (int a = 0; a < path[i].size(); a++) {
                //     System.out.print("(" + path[i].get(a) + ") ");
                // }
                // System.out.println();
            }
            
            
        }
        
        // 2. 모든 로봇이 운송을 마칠때까지 반복하며 위험 상황 체크
        int answer = 0;
        int robot = routes.length;
        Set<String> posSet = new HashSet<>();
        HashMap<String, Integer> pos = new HashMap<>();
        int idx = 0;
        boolean[] isEnd = new boolean[n];
        
        while (robot > 0) {
            for (int i = 0; i < n; i++) {
                // 현재 로봇이 이미 운송을 마친 상태라면 해당 로봇은 패스
                if (isEnd[i]) continue;
                
                // 각 위치별 로봇 수 카운팅
                String cur = path[i].get(idx);
                pos.put(cur, pos.getOrDefault(cur, -1) + 1);
                
                if (path[i].size() - 1 == idx) {
                    isEnd[i] = true;
                    robot--;
                }
            }
            
            for (String key : pos.keySet()) {
                if (pos.get(key) != 0) answer++;
            }
            
            idx++;
            pos.clear();
        }
        
        return answer;
    }
    
    static ArrayList<String> findAllPath(int sx, int sy, int ex, int ey) {
        // 시작 위치 삽입
        ArrayList<String> path = new ArrayList<>();
        path.add(Integer.toString(sx) + ", " + Integer.toString(sy));
        
        // r을 먼저 고려
        while (sx != ex) {
            if (sx < ex) sx++;
            else if (sx > ex) sx--;
            path.add(Integer.toString(sx) + ", " + Integer.toString(sy));
        }
        
        // c 고려
        while (sy != ey) {
            if (sy < ey) sy++;
            else if (sy > ey) sy--;
            path.add(Integer.toString(sx) + ", " + Integer.toString(sy));
        }
        
        return path;
    }
}