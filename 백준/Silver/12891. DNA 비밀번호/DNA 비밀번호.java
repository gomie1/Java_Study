import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int S, P, num[], selectedNum[], res;
	static String str;
	static ArrayList<String> arr = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken()); // DNA 문자열의 길이
		P = Integer.parseInt(st.nextToken()); // 부분 문자열의 길이
		str = br.readLine(); // DNA 문자열
		
		// 'A', 'C', 'G', 'T'의 최소 개수 입력 받기
		st = new StringTokenizer(br.readLine());
		num = new int[4];
		for(int i = 0; i < 4; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		res = 0;
		selectedNum = new int[4];
		
		// 처음 P 길이의 부분 문자열 초기화
		for(int i = 0; i < P; i++) {
			createPwd(str.charAt(i));
		}
		
		// 첫 번쨰 부분 문자열이 조건을 만족하는지 확인
		if(checkPwd()) {
			res++;
		}
		
		// 슬라이딩 윈도우 적용
		for(int i = P; i < S; i++) {
			createPwd(str.charAt(i)); // 새로 추가된 문자
			removePrev(str.charAt(i - P)); // 이전 문자 제거
			
			if(checkPwd()) {
				res++;
			}
		}
		
		// 결과 출력
		System.out.println(res);
	}
	
	private static void createPwd(char c) {
		switch(c) {
			case 'A':
				selectedNum[0]++;
				break;
			case 'C':
				selectedNum[1]++;
				break;
			case 'G':
				selectedNum[2]++;
				break;
			default:
				selectedNum[3]++;
				break;
		}
	}
	
	private static void removePrev(char c) {
		switch(c) {
		case 'A':
			selectedNum[0]--;
			break;
		case 'C':
			selectedNum[1]--;
			break;
		case 'G':
			selectedNum[2]--;
			break;
		default:
			selectedNum[3]--;
			break;
		}
	}
	
	private static boolean checkPwd() {
		for(int i = 0; i < 4; i++) {
			if(selectedNum[i] < num[i]) {
				return false;
			}
		}
		
		return true;
	}
}