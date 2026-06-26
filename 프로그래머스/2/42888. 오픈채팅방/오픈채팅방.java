import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // 유저 ID별 닉네임 매칭하기
        Map<String, String> users = new HashMap<>(); // <ID, 닉네임>
        for (String str : record) {
            String[] info = str.split(" ");
            if (info[0].equals("Enter") || info[0].equals("Change")) users.put(info[1], info[2]);
        }
        
        // 최종 닉네임으로 결과 출력하기
        List<String> res = new ArrayList<>();
        for (String str : record) {
            String[] info = str.split(" ");
            if (info[0].equals("Change")) continue;
            
            if (info[0].equals("Enter")) res.add(users.get(info[1]) + "님이 들어왔습니다.");
            else res.add(users.get(info[1]) + "님이 나갔습니다.");
        }
        
        String[] answer = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        
        return answer;
    }
}