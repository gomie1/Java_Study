import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> wordSet = new HashSet<>();
        
        int player = 0; // 플레이어 번호
        int idx = 0; // 단어 인덱스
        int turn = 0; // 게임 턴 수
        char prev = ' '; // 이전 단어의 마지막 문자
        while (idx < words.length) {
            // 1. n회마다 게임 한 턴 증가
            if (player % n == 0) turn++;
            
            // 2. 탈락 조건 체크 
            // 2-1.현재 플레이어가 말하는 단어가 중복되는지 체크 (중복되면 탈락)
            // 2-2. 현재 단어가 앞사람이 말한 단어의 마지막 문자로 시작하는지 체크 (다르면 탈락)
            if (wordSet.contains(words[idx]) || (idx > 0 && prev != words[idx].charAt(0))) {
                answer[0] = player + 1;
                answer[1] = turn;
                break;
            }
            
            wordSet.add(words[idx]); // 중복되지 않으면 통과 (단어 셋에 추가)
            prev = words[idx].charAt(words[idx].length() - 1); // 마지막 문자 변경
            idx++; // 다음 단어로 인덱스 이동
            player = (player + 1) % n; // 다음 사람으로 차례 이동
        }

        return answer;
    }
}