import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static final int C = 10007;
	public static int N, K, dp[][] = new int[1001][1001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp[0][0] = 1;
		dp[1][0] = 1;
		dp[1][1] = 1;
		
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j <= i; j++) {
				if(i == 0 || j == 0) {
					dp[i][j] = 1;
				}
				else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % C;
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}

}
