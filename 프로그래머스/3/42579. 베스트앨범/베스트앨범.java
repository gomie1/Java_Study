import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르에 고유 번호 부여하기 + 장르별 노래 재생 횟수 저장하기
        Map<String, Integer> genre = new HashMap<>();
        Map<Integer, List<int[]>> playCnt = new HashMap<>();
        int num = 0;
        for (int i = 0; i < genres.length; i++) {
            if (!genre.containsKey(genres[i])) genre.put(genres[i], num++);
            
            List<int[]> lst = playCnt.getOrDefault(genre.get(genres[i]), new ArrayList<>());
            lst.add(new int[] {i, plays[i]}); // [노래 번호, 재생 횟수]
            playCnt.put(genre.get(genres[i]), lst);
        }
        
        // 2. 장르별 총 재생 횟수 계산
        List<int[]> total = new ArrayList<>();
        for (int key : playCnt.keySet()) {
            int sum = 0;
            List<int[]> lst = playCnt.get(key);
            for (int[] n : lst) sum += n[1];
            
            total.add(new int[] {key, sum});
        }
        
        // 3. 장르별 총 재생 횟수 정렬
        Collections.sort(total, Collections.reverseOrder((o1, o2) -> {
            return o1[1] - o2[1];
        }));
        
        // 4. 베스트 앨범 생성
        List<Integer> res = new ArrayList<>();
        for (int[] song : total) {
            List<int[]> lst = playCnt.get(song[0]);
            Collections.sort(lst, Collections.reverseOrder((o1, o2) -> {
                return o1[1] - o2[1];
            }));
            
            for (int i = 0; i < Math.min(lst.size(), 2); i++) {
                int[] cur = lst.get(i);
                res.add(cur[0]);
            }
        }
        
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }
}