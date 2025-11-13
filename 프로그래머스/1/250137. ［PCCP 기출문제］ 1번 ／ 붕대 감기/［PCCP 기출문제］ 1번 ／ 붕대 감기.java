class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int endTime = attacks[attacks.length - 1][0];
        int successCnt = 0;
        int idx = 0;
        int maxHealth = health;
        for (int time = 1; time <= endTime; time++) {
            // a. 몬스터가 공격
            if (attacks[idx][0] == time) {
                successCnt = 0;
                health -= attacks[idx++][1];
                // a-1. 체력이 0 이하가 되었다면 캐릭터는 죽음 (종료)
                if (health <= 0) break;
            } else { // b. 붕대 감기
                successCnt++;
                health = Math.min(maxHealth, health + bandage[1]); // 최대 체력 이상의 체력은 가질 수 없음
                // b-1. t초 연속으로 붕대를 감았다면 y만큼 체력 추가 회복 및 연속 성공 수 초기화
                if (successCnt == bandage[0]) {
                    health = Math.min(maxHealth, health + bandage[2]); // 최대 체력 이상의 체력은 가질 수 없음
                    successCnt = 0;
                }
            }
        }
        
        if (health > 0) return health;
        else return -1;
    }
}