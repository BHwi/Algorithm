import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[][] dp = new int[N + 1][2];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1][0] = arr[0];
		
		for(int i = 2; i < N + 1; i++) {
			dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + arr[i - 1];
			dp[i][1] = dp[i - 1][0] + arr[i - 1];
		}
		
		System.out.println(Math.max(dp[N][0], dp[N][1]));

	}

}
