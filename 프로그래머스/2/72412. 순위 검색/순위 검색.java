import java.util.*;

class Solution {
    static Map<String, List<Integer>> map;
    
    public int[] solution(String[] info, String[] query) {
        // 지원자의 정보로 만들수 있는 모든 경우와 각 경우의 점수들을 맵에 저장
        map = new HashMap<>();
        for (String str : info) {
            makeAll(str.split(" "), "", 0);
        }
        
        // 점수 이분탐색을 위해 map 안의 모든 정수 리스트를 정렬
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        int[] answer = new int[query.length];
        int idx = 0;
        for (int i = 0; i < query.length; i++) {
            String q = query[i].replaceAll(" and ", "");
            String[] qSplit = q.split(" ");
            String key = qSplit[0];
            int targetScore = Integer.parseInt(qSplit[1]);
            
            // 해당 조건의 키가 존재한다면 이분탐색 시작
            if (map.containsKey(key)) {
                List<Integer> lst = map.get(key);
                answer[idx++] = lst.size() - binarySearch(lst, targetScore);
            } else answer[idx++] = 0;
        }
        
        return answer;
    }
    
    static void makeAll(String[] info, String cur, int cnt) {
        if (cnt == 4) {
            if (!map.containsKey(cur)) map.put(cur, new ArrayList<>());
            map.get(cur).add(Integer.parseInt(info[4]));
            return;
        }
        
        // 현재 조건을 그대로 넣는 경우
        makeAll(info, cur+info[cnt], cnt+1);
        
        // 현재 조건을 신경쓰지 않는 경우
        makeAll(info, cur+'-', cnt+1);
    } 
    
    static int binarySearch(List<Integer> scores, int target) {
        int left = 0;
        int right = scores.size() - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (target <= scores.get(mid)) right = mid - 1;
            else left = mid + 1;
        }
        
        return left;
    }
}