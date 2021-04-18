import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, i, j, dp[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dp = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			if(i == 1) 
				dp[i] = Integer.parseInt(st.nextToken());
			else 
				dp[i] = Integer.parseInt(st.nextToken()) + dp[i - 1];
		}
		
		while(M --> 0) {
			st = new StringTokenizer(br.readLine());
			
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			
			sb.append(dp[j] - dp[i - 1] + "\n");
		}
		
		System.out.print(sb.toString());
	}

}
