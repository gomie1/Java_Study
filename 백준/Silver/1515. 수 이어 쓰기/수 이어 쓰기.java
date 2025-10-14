import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int N = 1;
        String numStr = "";
        int idx = 0;
        while (true) {
            if (idx == input.length()) {
                System.out.println(N-1);
                break;
            }

            numStr = Integer.toString(N++);
            for (int i = 0; i < numStr.length(); i++) {
                if (input.charAt(idx) == numStr.charAt(i)) {
                    idx++;
                    if (input.length() <= idx) break;
                }
            }
        }
    }
}