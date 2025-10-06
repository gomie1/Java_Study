import java.util.*;

class Solution {
    static List<Integer> chosenA;
    static int max, answer[];
    
    public int[] solution(int[][] dice) {
        // 1. A가 가져가는 주사위의 수 계산
        int n = dice.length / 2;
        
        // 2. A가 가져갈 주사위 고르기
        chosenA = new ArrayList<>();
        max = 0;
        answer = new int[n];
        combination(n, 0, dice.length, dice);

        return answer;
    }
    
    static int factorial(int n) {
        int num = 1;
        for (int i = 1; i <= n; i++) {
            num *= i;
        }
        return num;
    }
    
    static void combination(int n, int start, int end, int[][] dice) {
        if (chosenA.size() == n) {
            // 3. B가 가져간 주사위 번호 저장
            List<Integer> chosenB = new ArrayList<>();
            for (int i = 0; i < dice.length; i++) {
                if (chosenA.contains(i)) continue;
                chosenB.add(i);
            }
            
            // 4. A, B가 가져간 주사위들로 만들 수 있는 모든 합 계산
            List<Integer> sumsA = new ArrayList<>();
            calculateSum(n, 0, 0, sumsA, chosenA, dice);
            
            List<Integer> sumsB = new ArrayList<>();
            calculateSum(n, 0, 0, sumsB, chosenB, dice);
            
            // 5. A가 승리할 확률 구하기
            int winCount = calculateWin(sumsA, sumsB);
            if (max < winCount) {
                max = winCount;
                for (int i = 0; i < n; i++) {
                    answer[i] = chosenA.get(i) + 1;
                }
            }
            
            return;
        }
        
        for (int i = start; i < end; i++) {
            chosenA.add(i);
            combination(n, i+1, end, dice);
            chosenA.remove(chosenA.size() - 1);
        }
    }
    
    static void calculateSum(int n, int idx, int curSum, List<Integer> allSums, List<Integer> chosen, int[][] dice) {
        if (idx == n) {
            allSums.add(curSum);
            return;
        }
        
        for (int i = 0; i < 6; i++) {
            int newSum = curSum + dice[chosen.get(idx)][i];
            calculateSum(n, idx+1, newSum, allSums, chosen, dice);
        }
    }
    
    static int calculateWin(List<Integer> arrA, List<Integer> arrB) {
        Collections.sort(arrA);
        Collections.sort(arrB);
        
        int win = 0;
        int ptrB = 0;
        for (int a : arrA) {
            while (ptrB < arrB.size() && a > arrB.get(ptrB)) ptrB++;
            win += ptrB;
        }
        
        return win;
    }
}