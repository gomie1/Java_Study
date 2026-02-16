import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 1. 숫자를 문자열 배열로 변환
        String[] strNums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNums[i] = String.valueOf(numbers[i]);
        }
        
        // 2. 커스텀 정렬 (with lambda)
        Arrays.sort(strNums, (o1, o2) -> {
            String str1 = o1 + o2;
            String str2 = o2 + o1;
            return str2.compareTo(str1);
        });
        
        // 3. 예외 처리 (모든 숫자가 0인 경우)
        if (strNums[0].equals("0")) return "0";
        
        // 4. StringBuilder로 문자열 합치기
        StringBuilder sb = new StringBuilder();
        for (String s : strNums) sb.append(s);
        
        return sb.toString();
    }
}