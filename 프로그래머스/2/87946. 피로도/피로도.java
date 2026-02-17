class Solution {
    static boolean[] visited;
    static int answer, path[];
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        path = new int[dungeons.length];
        answer = 0;
        permutation(0, k, dungeons);
        return answer;
    }
    
    static void permutation(int cnt, int k, int[][] dungeons) {
        if (cnt == dungeons.length) {
            int count = 0;
            for (int n : path) {
                if (dungeons[n][0] <= k) {
                    k -= dungeons[n][1];
                    count++;
                }
            }
            
            answer = Math.max(answer, count);
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path[cnt] = i;
                permutation(cnt+1, k, dungeons);
                visited[i] = false;
            }
        }
    }
}