import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 전화번호가 문자열로 되어있기 때문에, 사전 순으로 정렬됨
        // 사전 순 정렬은 접두어가 같으면 이어서 나오기 때문에 앞뒤만 확인하면 됨
        // ex. "가" > "가나" > "가나다", "1" > "11" > "12" > "113" > "4"
        Arrays.sort(phone_book);
        
        boolean answer = true;
        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(phone_book[i-1])) {
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}