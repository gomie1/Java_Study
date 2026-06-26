import java.util.*;

// 시간을 다루는 문제는 보통 초로 변환 후 다루듯이, 날짜도 일로 변환 후 활용!!
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int n = privacies.length; // 개인정보의 수
        int todayInt = changeDateType(today);
        
        // 유효기간을 일로 변환 후 종류별로 map에 저장
        Map<String, Integer> map = new HashMap<>();
        StringTokenizer st;
        for (String term : terms) {
            st = new StringTokenizer(term);
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()) * 28);
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(privacies[i]);
            int date = changeDateType(st.nextToken()) + map.get(st.nextToken());
            if (date <= todayInt) res.add(i+1);
        }
        
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }
    
    static int changeDateType(String date) {
        String[] ymd = date.split("\\."); // '.'은 역슬래시로 감싸주어야 인식됨
        
        // ex. 2022.05.19 -> year = 2021 * 12 * 28, month = 4 * 28, day = 19
        int year = (Integer.parseInt(ymd[0]) - 1) * 12 * 28;
        int month = (Integer.parseInt(ymd[1]) - 1) * 28;
        int day = Integer.parseInt(ymd[2]); // 모든 달은 28일까지 있다고 가정
        
        return year + month + day;
    }
}