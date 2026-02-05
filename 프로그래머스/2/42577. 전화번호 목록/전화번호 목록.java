import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        HashSet<String> numbers = new HashSet<>();
        numbers.add(phone_book[0]);
        
        StringBuilder sb;
        for (int i = 1; i < phone_book.length; i++) {
            sb = new StringBuilder();
            for (char c : phone_book[i].toCharArray()) {
                sb.append(c);
                if (numbers.contains(sb.toString())) return false;
            }
            numbers.add(phone_book[i]);
        }

        return true;
    }
}