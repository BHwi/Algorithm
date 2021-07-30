import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> s = new HashSet<>();
		
		char[] s1 = (" " + br.readLine()).toCharArray();
		char[] s2 = (" " + br.readLine()).toCharArray();
		
		int[][] dp = new int[s1.length][s2.length];
		int max = 0;
		
		for(int i = 1; i < s1.length; i++) {
			for(int j = 1; j < s2.length; j++) {
				if(s1[i] == s2[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1; 
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		
		System.out.println(max);
	}

}
