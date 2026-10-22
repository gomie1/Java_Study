import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nickname = new HashMap<>();
        int cnt = 0;
        for (String r : record) {
            String[] input = r.split(" ");
            if (!input[0].equals("Leave")) nickname.put(input[1], input[2]);
            if (input[0].equals("Enter") || input[0].equals("Leave")) cnt++;
        }
        
        String[] answer = new String[cnt];
        int idx = 0;
        for (int i = 0; i < record.length; i++) {
            String[] input = record[i].split(" ");
            
            if (input[0].equals("Enter")) answer[idx++] = nickname.get(input[1]) + "님이 들어왔습니다.";
            else if (input[0].equals("Leave")) answer[idx++] = nickname.get(input[1]) + "님이 나갔습니다.";
        }
        
        return answer;
    }
}