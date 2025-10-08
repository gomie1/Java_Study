import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 1. terms를 Map으로 저장하기
        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] str = term.split(" ");
            termsMap.put(str[0], Integer.parseInt(str[1]));
        }
        
        // 2. 오늘 날짜를 String -> Integer로 변경
        String[] todaySplit = today.split("\\.");
        int todayInt = Integer.parseInt(todaySplit[0]) * 10000 + Integer.parseInt(todaySplit[1]) * 100 + Integer.parseInt(todaySplit[2]);
        
        // 3. 각 개인정보별 만료일 계산 + 파기 여부 결정
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] str = privacies[i].split(" ");
            int period = termsMap.get(str[1]);
            
            String[] strDate = str[0].split("\\.");
            int date = datePlus(strDate[0], strDate[1], strDate[2], period);
            
            if (date < todayInt) ans.add(i+1);
        }
        
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
    
    // 만료일 계산 함수
    static int datePlus (String y, String m, String d, int period) {
        int yearInt = Integer.parseInt(y);
        int monthInt = Integer.parseInt(m);
        int dayInt = Integer.parseInt(d);
        
        if (dayInt == 1) {
            monthInt--;
            dayInt = 28;
        } else dayInt--;
        
        monthInt += period;
        if (monthInt > 12) yearInt += (monthInt - 1) / 12;
        monthInt = (monthInt - 1) % 12 + 1;
        
        return yearInt * 10000 + monthInt * 100 + dayInt;
    }
}