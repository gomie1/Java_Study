import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, isSelected[];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        isSelected = new int[M];
        combination(0, 1);
    }
    
    private static void combination(int idx, int start) {
        if(idx == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(isSelected[i] + " ");
            }
            System.out.println();

            return;
        }

        for (int i = start; i <= N; i++) {
            isSelected[idx] = i;
            combination(idx+1, i+1);
        }
    }
}