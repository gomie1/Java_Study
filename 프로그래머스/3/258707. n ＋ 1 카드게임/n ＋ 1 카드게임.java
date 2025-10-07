import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        int target = n + 1;
        
        // 1. 초기 카드 설정
        Set<Integer> myCards = new HashSet<>();
        for (int i = 0; i< n/3; i++) {
            myCards.add(cards[i]);
        }
        
        // 2. 게임 진행
        int round = 1;
        int cardIdx = n / 3;
        Set<Integer> keptCards = new HashSet<>(); // 코인을 지불하고 킵한 카드
        while (cardIdx < n) {
            // 2-1. 현재 라운드의 카드 2장 뽑기
            // 이번 라운드에 뽑은 2장은 일단 킵 후보로 keptCards에 추가됨
            keptCards.add(cards[cardIdx++]);
            if (cardIdx < n) keptCards.add(cards[cardIdx++]);
            else break;
            
            // 2-2. 그리디 전략: 최소 코인으로 라운드를 통과하는 방법 찾기
            // A. 코인 0개: myCards에서 2장 사용
            if (findAndUsePair(myCards, myCards, target, 0)) {
                round++;
                continue;
            }
            
            // B. 코인 1개: myCards에서 1장 + keptCards에서 1장 사용
            if (coin >= 1 && findAndUsePair(myCards, keptCards, target, 1)) {
                coin -= 1;
                round++;
                continue;
            }
            
            // C. 코인 2개: keptCards에서 2장 사용
            if (coin >= 2 && findAndUsePair(keptCards, keptCards, target, 2)) {
                coin -= 2;
                round++;
                continue;
            }
            
            // 2-3. 모든 방법을 시도했지만 다음 라운드로 갈 수 없을 경우 종료
            break;
        }
        
        return round;
    }
    
    static boolean findAndUsePair(Set<Integer> A, Set<Integer> B, int target, int mode) {
        for (int cardA : A) {
            int neededNum = target - cardA; // 필요한 카드 숫자
            
            // A에서 2장 사용
            if (mode == 0) {
                if (A.contains(neededNum)) {
                    A.remove(cardA);
                    A.remove(neededNum);
                    return true;
                }
            }
            
            // A에서 1장, B에서 1장 사용
            else if (mode == 1) {
                if (B.contains(neededNum)) {
                    A.remove(cardA);
                    B.remove(neededNum);
                    return true;
                }
            }
            
            // B에서 2장 사용
            else if (mode == 2) {
                if (B.contains(neededNum)) {
                    B.remove(cardA);
                    B.remove(neededNum);
                    return true;
                }
            }
        }
        
        return false;
    }
}