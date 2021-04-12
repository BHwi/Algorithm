import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N;
	public static long dp[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp = new long[N + 1][2];
		
		// dp[자리 수][마지막 자리 수] : 개수
		
		dp[1][1] = 1;
		
		for(int i = 2; i <= N; i++) {
			dp[i][0] = dp[i - 1][1] + dp[i - 1][0];
			dp[i][1] = dp[i - 1][0];
		}
		
		System.out.println(dp[N][0] + dp[N][1]);
	}

}
