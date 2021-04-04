import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, dp[][], arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dp = new int[N][M];
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve();
		
		System.out.println(dp[N - 1][M - 1]);
		
	}
	
	public static void solve() {
		dp[0][0] = arr[0][0];
		
		for(int i = 1; i < M; i++) {
			dp[0][i] = dp[0][i - 1] + arr[0][i];
		}
		
		for(int i = 1; i < N; i++) {
			dp[i][0] = dp[i - 1][0] + arr[i][0];
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 1; j < M; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i - 1][j - 1], dp[i][j - 1])) + arr[i][j];
			}
		}
	}

}
