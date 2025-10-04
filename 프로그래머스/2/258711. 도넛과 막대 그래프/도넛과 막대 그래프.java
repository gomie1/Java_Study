import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        // 1. 정점의 개수(n) 찾기
        int n = 0;
        for (int[] edge : edges) n = Math.max(n, Math.max(edge[0], edge[1]));
        
        // 2. 정점별 나가는 간선과 들어오는 간선의 개수 카운팅
        int[] input = new int[n+1];
        int[] output = new int[n+1];
        for (int[] edge : edges) {
            input[edge[1]]++;
            output[edge[0]]++;
        }
        
        // 3. 생성한 정점 찾기         
        // * 생성한 정점: 나가는 간선이 2개 이상이면서, 들어오는 간선은 없는 정점
        int[] answer = new int[4];
        int vertex = 0;
        for (int idx = 1; idx <= n; idx++) {
            //if (input[idx] == 0 && output[idx] >= 2) vertex = idx;
            if(output[idx] - input[idx] > 1) {
                answer[0] = idx;
                break;
            }
        }
       // answer[0] = vertex;
        
        // 4. input 배열에서 생성 정점으로부터의 간선 제거
        // for (int[] edge : edges) {
        //     if (edge[0] == vertex) input[edge[1]]--;
        // }
        
        // 5. 모양 찾기 (서브 그래프 분류)
        for (int idx = 1; idx <= n; idx++) {
            if (idx == answer[0]) continue;
            
            // 막대 그래프 분류: output이 0인 정점(꼬리) 찾기
            if (output[idx] == 0 && input[idx] > 0) answer[2]++;
            
            // 8자 그래프 분류: input, output이 모두 2인 정점(교차점) 찾기
            if (input[idx] >= 2 && output[idx] >= 2) answer[3]++;
        }
        
        // 5-1. 도넛 모양 그래프 찾기
        // 도넛 모양 = 전체 서브 그래프의 수 - (막대 모양 + 8자 모양)
        answer[1] = output[answer[0]] - (answer[2] + answer[3]);
        return answer;
    }
}