import java.util.*;

class Solution {
    static class File implements Comparable<File> {
        int num;
        String head;
        String number;
        String tail;
        
        File (int num, String head, String number, String tail) {
            this.num = num;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        
        @Override
        public int compareTo(File o) {
            if (!this.head.equals(o.head)) return this.head.compareTo(o.head);
            return Integer.parseInt(this.number) - Integer.parseInt(o.number);
        }
    }
    
    public String[] solution(String[] files) {
        File[] parts = new File[files.length];
        for (int i = 0; i < files.length; i++) {
            // 1. HEAD 찾기
            String HEAD = "";
            int start = 0;
            for (int j = 0; j < files[i].length(); j++) {
                char c = files[i].charAt(j);
                if (Character.isDigit(c)) {
                    start = j;
                    break;
                }
                HEAD += c;
            }
            
            // 2. NUMBER 찾기
            String NUMBER = "";
            for (int j = start; j < files[i].length(); j++) {
                char c = files[i].charAt(j);
                if (!Character.isDigit(c)) {
                    start = j;
                    break;
                }
                NUMBER += c;
            }
            
            // 3. TAIL 찾기
            String TAIL = files[i].substring(start);
            parts[i] = new File(i, HEAD.toLowerCase(), NUMBER, TAIL);
        }
        
        Arrays.sort(parts);
        
        String[] answer = new String[parts.length];
        for (int i = 0; i < parts.length; i++) {
            answer[i] = files[parts[i].num];
        }
        
        return answer;
    }
}