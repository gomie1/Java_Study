import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 수포자 1, 2, 3의 찍기 패턴
        int[] st1 = {1, 2, 3, 4, 5};
        int[] st2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] st3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 문제 채점
        int[] score = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == st1[i%5]) score[0]++;
            if (answers[i] == st2[i%8]) score[1]++;
            if (answers[i] == st3[i%10]) score[2]++;
        }
        
        // 최대 점수 찾기
        int maxScore = 0;
        for (int i = 0; i < 3; i++) maxScore = Math.max(maxScore, score[i]);
        
        // 최대 점수와 같은 점수를 받은 수포자 찾기
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (score[i] == maxScore) res.add(i+1);
        }
        
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }
}