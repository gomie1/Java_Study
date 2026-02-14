class Solution {
    public String solution(String new_id) {
        // 1단계: 모든 대문자를 대응되는 소문자로 치환
        new_id = new_id.toLowerCase();
        
        // 2단계: 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자 제거
        StringBuilder tmp = new StringBuilder();
        for (char c : new_id.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') tmp.append(c);
        }
        new_id = tmp.toString();
        
        // 3단계: 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        new_id = new_id.replaceAll("\\.{2,}", ".");
        
        // 4단계: 마침표(.)가 처음이나 끝에 위치한다면 제거
        if (new_id.charAt(0) == '.') new_id = new_id.substring(1);
        if (new_id.length() > 1 && new_id.charAt(new_id.length() - 1) == '.') new_id = new_id.substring(0, new_id.length()-1);
        
        // 5단계: new_id가 빈 문자열이라면, "a" 대입
        if (new_id.isEmpty()) new_id += "a";
        
        // 6단계: new_id의 길이가 16자 이상이면, 첫 15개의 문제를 제외한 나머지 문자들은 모두 제거
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            
            // 만약 제거 후, 마침표(.) new_id의 끝에 위치한다면 제거
            if (new_id.charAt(14) == '.') new_id = new_id.substring(0, 14);
        }
        
        // 7단계: new_id의 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복
        if (new_id.length() <= 2) {
            char c = new_id.charAt(Math.max(0, new_id.length() - 1));
            System.out.println("마지막 문자 = " + c);
            while (new_id.length() != 3) {
                new_id += c;
            }
        }
        
        return new_id;
    }
}