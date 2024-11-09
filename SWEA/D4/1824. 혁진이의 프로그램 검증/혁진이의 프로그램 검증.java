import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int R, C;
	static char[][] arr;
	static boolean [][][][]visit;
	static String res = "NO";
	static boolean flag;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			res="NO";
			arr = new char[R][C];
			visit = new boolean[16][4][R][C];
            flag = false;
            boolean temp = true;
			for(int i = 0; i < R; i++) {
				arr[i] = br.readLine().toCharArray();
                for(int j = 0; j < C; j++){
                    if(arr[i][j] == '@') temp =false;
                }
			}
            if(temp) {
                System.out.println("#" + test_case + " " + res);
                continue;
            }
			dfs(0, 0, 3, 0);
			System.out.println("#" + test_case + " " + res);
		}
	}
	
	private static void dfs(int x, int y, int dir, int memory) {
		//System.out.println("x = " + x + ", y = " + y + ", dir = " + dir + ", cnt = " + cnt + ", memory = " + memory);
		if(flag) return;
        if(visit[memory][dir][x][y]) {
			return;
		}
		if(arr[x][y] == '@') {
			res = "YES";
            flag = true;
			return;
		}
		visit[memory][dir][x][y] = true;
		if(arr[x][y] - '0' >= 0 && arr[x][y] - '0' <= 9) { 
			memory = arr[x][y] - '0';
		}
		else if(arr[x][y] == '^' || arr[x][y] == 'v' || arr[x][y] == '<' || arr[x][y] == '>') {
			switch(arr[x][y]) {
			case '^':
				dir = 0;
				break;
			case 'v':
				dir = 1;
				break;
			case '<':
				dir = 2;
				break;
			case '>':
				dir = 3;
				break;
			}
		}
		else if(arr[x][y] == '_') {
			if(memory == 0) dir = 3;
			else dir = 2;
		}
		else if(arr[x][y] == '|') {
			if(memory == 0) dir = 1;
			else dir = 0;
		}
		else if(arr[x][y] == '+') {
			if(memory == 15) memory = 0;
			else memory += 1;
		}
		else if(arr[x][y] == '-') {
			if(memory == 0) memory = 15;
			else memory -= 1;
		}
		
		if(arr[x][y] == '?') {
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0) nx = R-1;
				else if(nx >= R) nx = 0;
				else if(ny < 0) ny = C-1;
				else if(ny >= C) ny = 0;
				if (!visit[memory][i][nx][ny]){
					dfs(nx, ny, i, memory);
                    visit[memory][dir][nx][ny] = false;
                    if(flag) return;
                }
			}
		}
		else {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx < 0) nx = R-1;
			else if(nx >= R) nx = 0;
			else if(ny < 0) ny = C-1;
			else if(ny >= C) ny = 0;
			
			//System.out.println("nx = " + nx + ", ny = " + ny);
            if (!visit[memory][dir][nx][ny]){
				dfs(nx, ny, dir, memory);
            }
		}
	}
}
