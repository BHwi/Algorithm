import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static boolean[][] alphabet;
	public static int[] cnt, valid;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		alphabet = new boolean[N][26];
		cnt = new int[N];
		valid = new int[N];
		
		for(int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			
			for(int j = 0; j < input.length; j++) {
				if(!alphabet[i][input[j] - 'a']) {
					alphabet[i][input[j] - 'a'] = true;
					cnt[i]++;
					valid[i]++;
				}
			}
		}
		
		while(M --> 0) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			char ch = st.nextToken().charAt(0);
			
			if(isVowel(ch)) {}
			else {
				reCount(num, (char) (ch - 'a'));
			}
			
			sb.append(solve() + "\n");
		}
		
		System.out.print(sb);
	}
	
	public static int solve() {
		int ans = 0;
		
		for(int i = 0; i < N; i++) {
			if(cnt[i] == valid[i]) ans++; 
		}
		
		return ans;
	}
	
	public static boolean reCount(int num, char ch) {
		if(num == 1) {
			for(int i = 0; i < N; i++) {
				if(alphabet[i][ch]) cnt[i]--;
			}
		}
		else {
			for(int i = 0; i < N; i++) {
				if(alphabet[i][ch]) cnt[i]++;
			}
		}
		
		return true;
	}
	
	public static boolean isVowel(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}

}
