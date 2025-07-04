import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int val = 0;
        for (int i = 0; i < 3; i++) {
            String input = br.readLine();
            if (input.equals("Fizz") || input.equals("Buzz") || input.equals("FizzBuzz")) continue;

            val = Integer.parseInt(input);
            val += 3 - i;
            break;
        }

        if (val % 3 == 0) System.out.println(val % 5 == 0 ? "FizzBuzz" : "Fizz");
        else if (val % 5 == 0) System.out.println(val % 3 == 0 ? "FizzBuzz" : "Buzz");
        else System.out.println(val);
    }
}