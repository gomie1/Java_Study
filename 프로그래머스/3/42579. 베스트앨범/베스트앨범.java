import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 1. 각 장르별로 재생 횟수의 총합 구하기 + 노래별로 고유번호 메기고 장르끼리 묶기
        HashMap<String, Integer> total = new HashMap<>();
        HashMap<String, List<int[]>> songs = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
            songs.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new int[] {i, plays[i]});
        }
        
        // 2. 총 재생 횟수를 기준으로 장르 정렬
        List<String> sortedGenres = new ArrayList<>(total.keySet());
        Collections.sort(sortedGenres, (o1, o2) -> {
            return total.get(o2) - total.get(o1);
        });
        
        // 3. 총합이 높은 순서대로 장르 내 노래 선택
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < sortedGenres.size(); i++) {
            List<int[]> lst = songs.get(sortedGenres.get(i));
            if (lst.size() < 2) {
                res.add(lst.get(0)[0]); 
                continue;
            }
            
            Collections.sort(lst, (o1, o2) -> {
                if (o1[1] != o2[1]) return o2[1] - o1[1];
                return o1[0] - o2[0];
            });
            
            for (int j = 0; j < 2; j++) {
                res.add(lst.get(j)[0]);
            }
        }
        
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }
}