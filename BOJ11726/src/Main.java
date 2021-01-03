import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N + 1];
		
		dp[0] = 1; dp[1] = 1;
		
		for(int i = 2; i < N + 1; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
		}
		
		System.out.print(dp[N]);

	}

}
