import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N, dp[] = new int[31];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp[2] = 3;
		dp[4] = 11;
		
		if(N % 2 == 1) {
			System.out.println(0);
			System.exit(0);
		} 
		else {
			for(int i = 6; i <= N; i += 2) {
				for(int j = 2; i - j > 0; j++) {
					if(j == 2) dp[i] += dp[i - j] * 3;
					else dp[i] += dp[i - j] * 2;
				}
				dp[i] += 2;
			}
			System.out.println(dp[N]);
		}
	}
}
