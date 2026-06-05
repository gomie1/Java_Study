import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 1. 전화번호 정렬하기
        // (* 전화번호가 String이기 때문에, 정렬하면 접두어가 같은 단어가 이어서 나옴)
        Arrays.sort(phone_book);
        
        // 2. 현재 전화번호와 다음 전화번호를 비교하며, 접두어인 경우를 찾으면 종료
        for (int i = 0; i < phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) return false;
        }
        
        return true;
    }
}