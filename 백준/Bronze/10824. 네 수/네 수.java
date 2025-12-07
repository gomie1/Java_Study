import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");

        System.out.println(Long.parseLong(nums[0] + nums[1]) + Long.parseLong(nums[2] + nums[3]));
    }
}