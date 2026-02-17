import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> nameMap = new HashMap<>(); // key: ID, value: Nickname
        int cnt = 0;
        for (String str : record) {
            String[] cmd = str.split(" ");
            if (cmd[0].equals("Enter") || cmd[0].equals("Change")) nameMap.put(cmd[1], cmd[2]);
            if (cmd[0].equals("Enter") || cmd[0].equals("Leave")) cnt++;
        }
        
        String[] answer = new String[cnt];
        int idx = 0;
        for (int i = 0; i < record.length; i++) {
            String[] cmd = record[i].split(" ");
            
            if (cmd[0].equals("Enter")) answer[idx++] = nameMap.get(cmd[1]) + "님이 들어왔습니다.";
            else if (cmd[0].equals("Leave")) answer[idx++] = nameMap.get(cmd[1]) + "님이 나갔습니다.";
        }
        
        return answer;
    }
}