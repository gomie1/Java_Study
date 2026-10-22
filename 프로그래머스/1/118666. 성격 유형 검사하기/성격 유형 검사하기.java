import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> cnt = new HashMap<>();
        Character[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        for (char type : types) cnt.put(type, 0);
        
        int[] score = new int[8];
        int val = 3;
        for (int i = 1; i <= 7; i++) {
            if (i < 4) score[i] = val--;
            else if (i > 4) score[i] = ++val;
        }
        
        for (int i = 0; i < survey.length; i++) {
            if (choices[i] < 4) cnt.put(survey[i].charAt(0), cnt.get(survey[i].charAt(0)) + score[choices[i]]);
            else if (choices[i] > 4) cnt.put(survey[i].charAt(1), cnt.get(survey[i].charAt(1)) + score[choices[i]]);
        }
        
        StringBuilder sb = new StringBuilder();
        // 1번 지표
        if (cnt.get('R') == cnt.get('T')) sb.append('R');
        else sb.append(cnt.get('R') > cnt.get('T') ? 'R' : 'T');
        
        // 2번 지표
        if (cnt.get('C') == cnt.get('F')) sb.append('C');
        else sb.append(cnt.get('C') > cnt.get('F') ? 'C' : 'F');
        
        // 3번 지표
        if (cnt.get('J') == cnt.get('M')) sb.append('J');
        else sb.append(cnt.get('J') > cnt.get('M') ? 'J' : 'M');
        
        // 4번 지표
        if (cnt.get('A') == cnt.get('N')) sb.append('A');
        else sb.append(cnt.get('A') > cnt.get('N') ? 'A' : 'N');
        
        return sb.toString();
    }
}