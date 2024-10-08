import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int num[], isSelected[], result[];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        num = new int[9];
        for (int i = 0; i < 9; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        
        isSelected = new int[7];
        result = new int[7];
        combination(0, 0, 0);
        
        for(int res : result) {
            System.out.println(res);
        }
    }
    
    private static void combination(int idx, int start, int sum) {
        if(sum > 100) return;
        
        if(idx == 7) {
            if(sum == 100) {
                for (int i = 0; i < 7; i++) {
                    result[i] = isSelected[i];
                }
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            isSelected[idx] = num[i];
            combination(idx+1, i+1, sum+num[i]);
        }
    }
}