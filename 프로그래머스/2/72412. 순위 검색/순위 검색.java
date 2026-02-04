import java.util.*;

class Solution {
    static HashMap<String, List<Integer>> map;
    
    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();
        for (String s : info) {
            makeSentence(s.split(" "), "", 0);
        }
        
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String q = query[i].replace(" and ", "");
            String[] cmd = q.split(" "); // {조건, 점수}
            
            List<Integer> lst = map.get(cmd[0]);
            if (lst == null) answer[i] = 0;
            else answer[i] = binarySearch(lst, Integer.parseInt(cmd[1]));
        }
        
        return answer;
    }
    
    static void makeSentence(String[] cmd, String str, int cnt) {
        if (cnt == 4) {
            map.computeIfAbsent(str, k -> new ArrayList<>()).add(Integer.parseInt(cmd[4]));
            return;
        }
        
        makeSentence(cmd, str+cmd[cnt], cnt+1);
        makeSentence(cmd, str+"-", cnt+1);
    }
    
    static int binarySearch(List<Integer> lst, int score) {
        int start = 0;
        int end = lst.size();
        while (start < end) {
            int mid = (start + end) / 2;
            
            if (lst.get(mid) >= score) end = mid;
            else start = mid + 1;
        }
        
        return lst.size() - start;
    }
}