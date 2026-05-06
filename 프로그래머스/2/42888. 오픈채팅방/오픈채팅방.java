import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // 1. ID별 닉네임 저장하기
        Map<String, String> nickname = new HashMap<>();
        for (String str : record) {
            String[] info = str.split(" ");
            if (info[0].equals("Leave")) continue;
            nickname.put(info[1], info[2]);
        }
        
        // 2. 최종 닉네임으로 기록 출력하기
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            String[] info = record[i].split(" ");
            if (info[0].equals("Change")) continue;
            
            StringBuilder sb = new StringBuilder();
            sb.append(nickname.get(info[1]));
            if (info[0].equals("Enter")) sb.append("님이 들어왔습니다.");
            if (info[0].equals("Leave")) sb.append("님이 나갔습니다.");
            
            answer.add(sb.toString());
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}