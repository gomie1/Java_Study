import java.util.*;

class Solution {
    static boolean[] visited;
    static int n, answer, order[];
    
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        answer = 0;
        
        visited = new boolean[n];
        order = new int[n];
        permutation(0, k, dungeons);
        
        return answer;
    }
    
    static void permutation(int idx, int k, int[][] dungeons) {
        if (idx == n) {
            int cnt = 0;
            for (int i : order) {
                if (dungeons[i][0] <= k) {
                    k -= dungeons[i][1];
                    cnt++;
                } else break;
            }
            answer = Math.max(answer, cnt);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[idx] = i;
                permutation(idx+1, k, dungeons);
                visited[i] = false;
            }
        }
    }
}