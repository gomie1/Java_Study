import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int zero = 0;
        int one = 0;
        for (char c : S.toCharArray()) {
            if (c == '0') zero++;
            else one++;
        }

        char[] arr = S.toCharArray();
        int eraseZero = 0;
        int eraseOne = 0;
        int idxZero = S.length() - 1;
        int idxOne = 0;
        while (true) {
            if (eraseZero == zero/2 && eraseOne == one/2) break;

            if (eraseZero < zero/2 && idxZero >= 0 && arr[idxZero] == '0') {
                arr[idxZero] = 'x';
                eraseZero++;
            }

            if (eraseOne < one/2 && idxOne < arr.length && arr[idxOne] == '1') {
                arr[idxOne] = 'x';
                eraseOne++;
            }

            idxZero--;
            idxOne++;
        }

        String ans = "";
        for (char c : arr) {
            if (c != 'x') ans += c;
        }
        System.out.println(ans);
    }
}