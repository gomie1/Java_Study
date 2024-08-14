import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int N, M;
    static int[] numbers; // 순열 저장 배열
    static boolean[] isSelected; // 인덱스에 해당하는 숫자가 사용 중인지 저장하는 배열
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 3
        M = Integer.parseInt(st.nextToken()); // 1
        
        numbers = new int[M];
        isSelected = new boolean[N+1];
        
        permutation(0);
    }
    
    private static void permutation(int cnt) {
        if(cnt == M) { // 순열 생성 완료 조건
            for(int i = 0; i < M; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        }
        
        for(int i = 1; i <= N; i++) {
            if(!isSelected[i]) {
                numbers[cnt] = i;
                isSelected[i] = true;
                permutation(cnt+1);
                isSelected[i] = false;
            }
        }
    }

}