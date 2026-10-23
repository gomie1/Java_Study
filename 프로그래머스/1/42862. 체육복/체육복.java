import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);
        
        for (int student : reserve) cnt[student-1] += 1; // 여벌 옷 추가
        for (int student : lost) cnt[student-1] -= 1; // 도난
        
        int answer = 0;
        for (int i = 0; i < n; i++) {            
            if (i == 0) {
                if (cnt[i] >= 1) answer++;
                else if (cnt[i] == 0 && cnt[i+1] == 2) {
                    answer++;
                    cnt[i]++;
                    cnt[i+1]--;
                }
            } else if (i == n-1) {
                if (cnt[i] >= 1) answer++;
                else if (cnt[i] == 0 && cnt[i-1] == 2) {
                    answer++;
                    cnt[i]++;
                    cnt[i-1]--;
                }
            } else {
                if (cnt[i] >= 1) answer++;
                else if (cnt[i] == 0) {
                    if (cnt[i-1] == 2) {
                        answer++;
                        cnt[i]++;
                        cnt[i-1]--;
                        continue;
                    } else if (cnt[i+1] == 2) {
                        answer++;
                        cnt[i]++;
                        cnt[i+1]--;
                    }
                }
            }
        }
        
        return answer;
    }
}