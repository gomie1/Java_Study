import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        
        List<String> cache = new LinkedList<>();
        cache.add(cities[0].toLowerCase());
        
        int answer = 5; // 처음은 항상 Miss
        for (int i = 1; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            
            if (cache.contains(city)) { // 캐시 안에 현재 도시가 있다면 "Hit"
                answer += 1;
                cache.remove(city); 
            } else { // 캐시 안에 현재 도시가 없다면 "Miss"
                answer += 5;
                if (cache.size() >= cacheSize) cache.remove(cache.size() - 1);
            }
            
            cache.add(0, city); // 현재 도시 맨 앞에 추가
        }
        
        return answer;
    }
}