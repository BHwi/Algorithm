import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static final int INF = 100_000 * 100 + 1;
	public static int N, K, arr[], dp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		dp = new int[INF];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.fill(dp, INF);
		dp[0] = 0;
		
		for(int i = 0; i <= K; i++) {
			for(int j = 0; j < N; j++) {
				if(i + arr[j] < INF) { 
					dp[i + arr[j]] = Math.min(dp[i + arr[j]], dp[i] + 1);
				}
			}
		}
		
		System.out.println(dp[K] == INF ? -1 : dp[K]);
	}

}
