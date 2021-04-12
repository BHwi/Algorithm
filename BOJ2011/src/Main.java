import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static final int INF = 1_000_000;
	public static char[] str;
	public static long dp[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine().toCharArray();
		
		if(str.length == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		if(str.length == 1) {
			if(str[0] == '0') {
				System.out.println(0);
				System.exit(0);
			}
			System.out.println(1);
			System.exit(0);
		}
		
		dp = new long[str.length + 1][2];
		
		// dp[현재][미결합 0, 결합 1]
		if(str[0] != '0') dp[1][0] = 1;
		else {
			System.out.println(0);
			System.exit(0);
		}
		if(str[1] != '0') dp[2][0] = 1;
		if(b(str[0], str[1]))
			dp[2][1] = 1;
		
		for(int i = 3; i <= str.length; i++) {
			if(str[i - 1] != '0') dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % INF;
			if(b(str[i - 2], str[i - 1])) dp[i][1] = (dp[i - 2][0] + dp[i - 2][1]) % INF;
		}
		
		System.out.println((dp[str.length][0] + dp[str.length][1]) % INF);
	}
	
	public static boolean b(char a, char b) {
		return Integer.parseInt(a + "" + b) >= 10 && Integer.parseInt(a + "" + b) <= 26;
 	}

}
