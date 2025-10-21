import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Stack<Character> leftStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            leftStack.add(str.charAt(i));
        }

        Stack<Character> rightStack = new Stack<>();
        for (int i = 0; i < M; i++) {
            String[] cmd = br.readLine().split(" ");
            
            // L: 커서를 왼쪽으로 한 칸 옮김
            if (cmd[0].equals("L") && !leftStack.isEmpty()) rightStack.push(leftStack.pop());
            
            // D: 커서를 오른쪽으로 한 칸 옮김
            else if (cmd[0].equals("D") && !rightStack.isEmpty()) leftStack.push(rightStack.pop());
            
            // B: 커서 왼쪽에 있는 문자를 삭제
            else if (cmd[0].equals("B") && !leftStack.isEmpty()) leftStack.pop();
            
            // P: 문자(cmd[1])를 커서 왼쪽에 추가
            else if (cmd[0].equals("P")) leftStack.push(cmd[1].charAt(0));
        }

        while (!leftStack.isEmpty()) rightStack.push(leftStack.pop());

        StringBuilder sb = new StringBuilder();
        while (!rightStack.isEmpty()) sb.append(rightStack.pop());
        System.out.println(sb);
    }
}