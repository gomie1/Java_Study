import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()), i, n, team,j;
        StringTokenizer st;
        while (T-->0){
            n = Integer.parseInt(br.readLine()); 
            int count[] = new int[202]; 
            int teamNum[] = new int[n]; 
            st = new StringTokenizer(br.readLine());
            for (i = 0; i < n; i++){
                teamNum[i] = team = Integer.parseInt(st.nextToken()); 
                count[team]++; 
            }
            int score[] = new int[202]; 

            int passTeam[] = new int[202]; 
            int minscore = 1<<30, minteam = -1;
            
            for (i = 0, j=1; i < n; i++){
                team = teamNum[i]; 
                if (count[team] < 6) 
                    continue;
                passTeam[team]++;
                if (passTeam[team] <= 4)
                    score[team] += j << 19; 
                if (passTeam[team] == 5){
                    score[team] += j; 
                    if (score[team] < minscore){ 
                        minscore = score[team];
                        minteam = team;
                    }
                }
                j++;
            }
            System.out.println(minteam); 
        }
    }
}