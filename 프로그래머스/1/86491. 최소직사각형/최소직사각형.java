class Solution {
    public int solution(int[][] sizes) {
        // 모든 명함에 대해 더 긴 변을 가로, 더 짧은 변을 세로로 두고 각각 max 값 찾기
        int width = 0;
        int length = 0;
        for (int i = 0; i < sizes.length; i++) {
            width = Math.max(width, sizes[i][0] < sizes[i][1] ? sizes[i][1] : sizes[i][0]);
            length = Math.max(length, sizes[i][0] < sizes[i][1] ? sizes[i][0] : sizes[i][1]);
        }
        
        int answer = width * length;
        return answer;
    }
}