import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 한 유저를 여러 번 신고해도 신고 횟수는 1로 처리되므로 중복 신고 제거
        Set<String> reportSet = new HashSet<>();
        for (String r : report) reportSet.add(r);
        
        Map<String, Integer> cnt = new HashMap<>(); // <유저ID, 신고당한 횟수>
        Map<String, List<String>> ids = new HashMap<>(); // <신고 당한 유저ID, 해당 유저를 신고한 유저들의 ID목록>
        
        for (String info : reportSet) {
            String[] s = info.split(" ");
            
            List<String> lst = new ArrayList<>();
            if (ids.containsKey(s[1])) lst = ids.get(s[1]);
            lst.add(s[0]);
            
            ids.put(s[1], lst);
            cnt.put(s[1], cnt.getOrDefault(s[1], 0) + 1);
        }
        
        // k번 이상 신고당한 ID 찾기
        List<String> users = new ArrayList<>();
        for (String key : cnt.keySet()) {
            if (cnt.get(key) >= k) users.add(key);
        }
        
        // 각 유저가 받은 메일 수 카운팅
        Map<String, Integer> mailCnt = new HashMap<>();
        for (String id : id_list) mailCnt.put(id, 0);
        
        for (String user : users) {
            List<String> lst = ids.get(user);
            for (String id : lst) mailCnt.put(id, mailCnt.get(id) + 1);
        }
        
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mailCnt.get(id_list[i]);
        }
        
        return answer;
    }
}