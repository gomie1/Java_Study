class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        // 1. 행렬 만들기
        int[][] mtrx = new int[rows+1][columns+1];
        int num = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                mtrx[i][j] = num++;
            }
        }
        
        // 2. 회전 및 최소값 찾기
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0]; // 2
            int y1 = queries[i][1]; // 2
            int x2 = queries[i][2]; // 5
            int y2 = queries[i][3]; // 4
            
            int tmp = mtrx[x1][y1];
            int min = Math.min(num, tmp);
            // 2-1. 북쪽 이동
            for (int x = x1; x < x2; x++) {
                mtrx[x][y1] = mtrx[x+1][y1];
                min = Math.min(min, mtrx[x][y1]);
            }
            
            // 2-2. 서쪽 이동
            for (int y = y1; y < y2; y++) {
                mtrx[x2][y] = mtrx[x2][y+1];
                min = Math.min(min, mtrx[x2][y]);
            }
            
            // 2-3. 남쪽 이동
            for (int x = x2; x > x1; x--) {
                mtrx[x][y2] = mtrx[x-1][y2];
                min = Math.min(min, mtrx[x][y2]);
            }
            
            // 2-4. 동쪽 이동
            for (int y = y2; y > y1+1; y--) {
                mtrx[x1][y] = mtrx[x1][y-1];
                min = Math.min(min, mtrx[x1][y]);
            }
            mtrx[x1][y1+1] = tmp;
            
            // 2-5. 최소값 저장
            answer[i] = min;
        }
        
        return answer;
    }
}