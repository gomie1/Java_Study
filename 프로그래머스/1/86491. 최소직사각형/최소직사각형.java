class Solution {
    public int solution(int[][] sizes) {
        int max_a = 0;
        int max_b = 0;
        
        for(int i = 0; i < sizes.length; i++) {
            int a = Math.max(sizes[i][0], sizes[i][1]);
            int b = Math.min(sizes[i][0], sizes[i][1]);
            max_a = Math.max(a, max_a);
            max_b = Math.max(b, max_b);
        }
        
        return max_a * max_b;
    }
}