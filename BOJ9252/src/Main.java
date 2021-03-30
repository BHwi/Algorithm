import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static char[] T, P;
	public static int[][] dp;
	public static String[][] dp_str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = ("0" + br.readLine()).toCharArray();
		P = ("0" + br.readLine()).toCharArray();
		
		dp = new int[P.length][T.length];
		dp_str = new String[P.length][T.length];
		
		for(int i = 0; i < P.length; i++) {
			Arrays.fill(dp_str[i], "");
		}
		
		for(int i = 1; i < P.length; i++) {
			for(int j = 1; j < T.length; j++) {
				if(P[i] == T[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					dp_str[i][j] = dp_str[i - 1][j - 1] + P[i];
				}
				else {
					if(dp[i - 1][j] > dp[i][j - 1]) {
						dp[i][j] = dp[i - 1][j];
						dp_str[i][j] = dp_str[i - 1][j];
					}
					else {
						dp[i][j] = dp[i][j - 1];
						dp_str[i][j] = dp_str[i][j - 1];
					}
				}
			}
		}
		
		System.out.println(dp[P.length - 1][T.length - 1]);
		System.out.println(dp_str[P.length - 1][T.length - 1]);
		
	}

}
