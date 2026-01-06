import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }

        void insert(int n) {
            if (n < this.data) {
                if (this.left == null) this.left = new Node(n);
                else this.left.insert(n);
            } else {
                if (this.right == null) this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 첫 번째 입력을 루트 노드로 설정
        Node root = new Node(Integer.parseInt(br.readLine()));

        // 2. 입력을 계속 받으며 트리 구축
        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            root.insert(Integer.parseInt(input));
        }

        // 3. 후위 순회
        postorder(root);
        System.out.println(sb);
    }

    static void postorder (Node node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        sb.append(node.data).append('\n');
    }
}