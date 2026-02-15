class Solution {
    public String solution(int[] numbers, String hand) {
        int[] leftPos = {3, 0};
        int[] rightPos = {3, 2};
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1) {
                leftPos[0] = 0;
                leftPos[1] = 0;
                sb.append('L');
            } else if (numbers[i] == 2) {
                double ld = calDist(leftPos[0], leftPos[1], 0, 1);
                double rd = calDist(rightPos[0], rightPos[1], 0, 1);
                if (ld < rd || ((ld == rd) && (hand.equals("left")))) {
                    leftPos[0] = 0;
                    leftPos[1] = 1;
                    sb.append('L');
                } else if (ld > rd || ((ld == rd) && (hand.equals("right")))) {
                    rightPos[0] = 0;
                    rightPos[1] = 1;
                    sb.append('R');
                }
            } else if (numbers[i] == 3) {
                rightPos[0] = 0;
                rightPos[1] = 2;
                sb.append('R');
            } else if (numbers[i] == 4) {
                leftPos[0] = 1;
                leftPos[1] = 0;
                sb.append('L');
            } else if (numbers[i] == 5) {
                double ld = calDist(leftPos[0], leftPos[1], 1, 1);
                double rd = calDist(rightPos[0], rightPos[1], 1, 1);
                if (ld < rd || ((ld == rd) && (hand.equals("left")))) {
                    leftPos[0] = 1;
                    leftPos[1] = 1;
                    sb.append('L');
                } else if (ld > rd || ((ld == rd) && (hand.equals("right")))) {
                    rightPos[0] = 1;
                    rightPos[1] = 1;
                    sb.append('R');
                }
            } else if (numbers[i] == 6) {
                rightPos[0] = 1;
                rightPos[1] = 2;
                sb.append('R');
            } else if (numbers[i] == 7) {
                leftPos[0] = 2;
                leftPos[1] = 0;
                sb.append('L');
            } else if (numbers[i] == 8) {
                double ld = calDist(leftPos[0], leftPos[1], 2, 1);
                double rd = calDist(rightPos[0], rightPos[1], 2, 1);
                if (ld < rd || ((ld == rd) && (hand.equals("left")))) {
                    leftPos[0] = 2;
                    leftPos[1] = 1;
                    sb.append('L');
                } else if (ld > rd || ((ld == rd) && (hand.equals("right")))) {
                    rightPos[0] = 2;
                    rightPos[1] = 1;
                    sb.append('R');
                }
            } else if (numbers[i] == 9) {
                rightPos[0] = 2;
                rightPos[1] = 2;
                sb.append('R');
            } else {
                double ld = calDist(leftPos[0], leftPos[1], 3, 1);
                double rd = calDist(rightPos[0], rightPos[1], 3, 1);
                if (ld < rd || ((ld == rd) && (hand.equals("left")))) {
                    leftPos[0] = 3;
                    leftPos[1] = 1;
                    sb.append('L');
                } else if (ld > rd || ((ld == rd) && (hand.equals("right")))) {
                    rightPos[0] = 3;
                    rightPos[1] = 1;
                    sb.append('R');
                }
            }
        }
        
        return sb.toString();
    }
    
    static double calDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}