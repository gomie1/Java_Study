class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        // 1. rows x colums 크기의 행렬 생성 및 초기화
        int[][] mtrx = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                mtrx[i][j] = num++;
            }
        }
        
        // 2. 쿼리 실행하기
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            
            int tmp = mtrx[x1][y1]; // 첫 원소는 잠시 빼두기
            int min = tmp;
            
            // 왼쪽 (아래에서 위로 옮기기)
            for (int x = x1; x < x2; x++) {
                mtrx[x][y1] = mtrx[x+1][y1];
                min = Math.min(min, mtrx[x][y1]);
            }
            
            // 아래쪽 (오른쪽에서 왼쪽으로 옮기기)
            for (int y = y1; y < y2; y++) {
                mtrx[x2][y] = mtrx[x2][y+1];
                min = Math.min(min, mtrx[x2][y]);
            }
            
            // 오른쪽 (위에서 아래로 옮기기)
            for (int x = x2; x > x1; x--) {
                mtrx[x][y2] = mtrx[x-1][y2];
                min = Math.min(min, mtrx[x][y2]);
            }
            
            // 위쪽 (왼쪽에서 오른쪽으로 옮기기)
            for (int y = y2; y > y1; y--) {
                mtrx[x1][y] = mtrx[x1][y-1];
                min = Math.min(min, mtrx[x1][y]);
            }
            
            mtrx[x1][y1+1] = tmp; // 마지막 원소 채우기
            answer[i] = min;
        }
        
        return answer;
    }
}