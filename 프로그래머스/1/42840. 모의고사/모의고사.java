import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[][] score = {
            {1, 0}, {2, 0}, {3, 0}
        };
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == s1[i%5]) score[0][1]++;
            if (answers[i] == s2[i%8]) score[1][1]++;
            if (answers[i] == s3[i%10]) score[2][1]++;
        }
        
        Arrays.sort(score, (o1, o2) -> {
            if (o1[1] != o2[1]) return o2[1] - o1[1];
            return o1[0] - o2[0];
        });
        
        int max = score[0][1];
        List<Integer> res = new ArrayList<>();
        res.add(score[0][0]);
        for (int i = 1; i < 3; i++) {
            if (score[i][1] < max) break;
            res.add(score[i][0]);
            max = Math.max(max, score[i][1]);
        }
        
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        
        return answer;
    }
}