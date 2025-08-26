import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] arr : clothes) {
            map.put(arr[1], map.getOrDefault(arr[1], 1) + 1);
        }
        
        int answer = 1;
        ArrayList<String> keys = new ArrayList<>(map.keySet());
        for (String s : keys) {
            answer *= map.get(s);
        }
        
        return answer - 1;
    }
}