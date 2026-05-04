import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int r = relation.length;
        int c = relation[0].length;
        List<Integer> keys = new ArrayList<>();
        
        // 1. 모든 컬럼 조합을 비트마스크로 탐색
        for (int i = 1; i < (1 << c); i++) {
            // 2. 최소성 검사: 이미 후보키로 등록된 조합이 현재 조합에 포함되는지 확인
            if (!isMinimal(i, keys)) continue;
            
            // 3. 유일성 검사
            if (isUnique(i, relation, r, c)) keys.add(i);
        }
        
        return keys.size();
    }
    
    static boolean isMinimal(int i, List<Integer> keys) {
        // (key & i) == key 라면, key에 있는 모든 비트가 i에도 들어있다는 뜻
        // 즉, key는 i의 부분집합이므로 최소성을 만족하지 못함
        for (int key : keys) {
            if ((key & i) == key) return false;
        }
        return true;
    }
    
    static boolean isUnique(int i, String[][] relation, int row, int col) {
        Set<String> data = new HashSet<>();
        
        for (int r = 0; r < row; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < col; c++) {
                // i의 c번째 비트가 0이 아닌지(= c번째 컬럼이 선택되었는지) 확인
                // -> 선택된 컬럼이라면 해당 데이터 sb에 연결
                if ((i & (1 << c)) != 0) sb.append(relation[r][c]).append("/");
            }
            data.add(sb.toString());
        }
        
        // 중복 없이 모든 행이 들어갔다면, size는 row와 같아야 함
        return data.size() == row;
    }
}