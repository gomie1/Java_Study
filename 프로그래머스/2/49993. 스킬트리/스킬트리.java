import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        HashMap<Character, Character> prev = new HashMap<>(); // key: 스킬, value: 선수스킬
        for (int i = 1; i < skill.length(); i++) {
            prev.put(skill.charAt(i), skill.charAt(i-1));
        }
        
        boolean[] isLearn = new boolean[26];
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            boolean res = true;
            
            for (char c : skill_trees[i].toCharArray()) {
                if (!prev.containsKey(c)) {
                    isLearn[c - 'A'] = true;
                }
                else {
                    int prevSkill = prev.get(c) - 'A';
                    if (isLearn[prevSkill]) isLearn[c - 'A'] = true;
                    else {
                        res = false;
                        break;
                    }
                }
            }
            
            if (res) answer++;
            Arrays.fill(isLearn, false);
        }
        
        return answer;
    }
}